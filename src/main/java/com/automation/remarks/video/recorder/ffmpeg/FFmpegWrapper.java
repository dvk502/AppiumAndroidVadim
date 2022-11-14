package com.automation.remarks.video.recorder.ffmpeg;

import com.automation.remarks.video.DateUtils;
import logic.init.BasePage;
import logic.init.BasePageWeb;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.automation.remarks.video.SystemUtils.*;
import static com.automation.remarks.video.recorder.VideoRecorder.conf;

/**
 * Created by sepi on 31.08.16.
 */
public class FFmpegWrapper extends BasePageWeb {

    private static final Logger log = org.apache.log4j.Logger.getLogger(FFMpegRecorder.class);

    public static final String RECORDING_TOOL = "ffmpeg.exe";
    private static final String TEM_FILE_NAME = "temporary";
    private static final String EXTENSION = ".mp4";
    public static String nameToFfmpeg;
    private CompletableFuture<String> future;
    private File temporaryFile;
    public String newKillLog;
    String subKillLog = "errrorrrr";

    public void startFFmpeg(String... args) {
        File videoFolder = new File(conf().folder());
        if (!videoFolder.exists()) {
            videoFolder.mkdirs();
        }

        temporaryFile = getTemporaryFile();
        final String[] commandsSequence = new String[]{
                FFmpegWrapper.RECORDING_TOOL,
                "-y",
                "-video_size", getScreenSize(),
                "-f", conf().ffmpegFormat(),
                "-i", conf().ffmpegDisplay(),
                "-an",
                "-framerate", String.valueOf(conf().frameRate()),
                "-pix_fmt", conf().ffmpegPixelFormat(),
                temporaryFile.getAbsolutePath()
        };

        List<String> command = new ArrayList<>();
        command.addAll(Arrays.asList(commandsSequence));
        command.addAll(Arrays.asList(args));
        driver.get("http://10.10.1.93:8080/TrackEnsure/login.do");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.future = CompletableFuture.supplyAsync(() -> runCommand(command));
    }

    public File stopFFmpegAndSave(String filename) {
        killFFmpeg();
        String killLog = newKillLog;
        if(killLog.equals("NFP")) {
            log.warn("PID FFMPEG Not Found!");
            log.warn("Maybe video was created before running the close command to the console.");
        } else {
            log.info("Process kill output: " + killLog);
        }

        File destFile = getResultFile(filename);
        this.future.whenCompleteAsync((out, errors) -> {
            temporaryFile.renameTo(destFile);
            if (recorderLogger) {
                log.debug("Recording output log: " + out + (errors != null ? "; ex: " + errors : ""));
            }
            log.info("WEB Recording finished to: " + destFile.getAbsolutePath());
        });
        nameToFfmpeg = null;
        return destFile;
    }

    private String killFFmpeg() {
        final String SEND_CTRL_C_TOOL_NAME = "SendSignalCtrlC.exe";
        System.out.println();
        System.out.println(BasePage.ConsoleColors.WHITE_BOLD_BRIGHT + "------------------------------------------------------------------------> WEB REC." + BasePage.ConsoleColors.RESET);
        Integer newPid = getPidOf();
        Integer countTryKill = 0;
        if (newPid!=null) {
            while (!subKillLog.equals("Sending") && countTryKill!=5) {
                    newKillLog = SystemUtils.IS_OS_WINDOWS ?
                            runCommand(SEND_CTRL_C_TOOL_NAME, newPid.toString()) :
                            runCommand("pkill", "-INT", RECORDING_TOOL);
                    subKillLog = newKillLog.substring(0, 7);
                    countTryKill++;
            }
                return newKillLog;
        } else {
            newKillLog = "NFP";
            return newKillLog;
        }
/*        if (!isNumeric(newKillLog)) {
            return killFFmpeg();
        } else {
            return newKillLog;
        }*/
    }

    public File getTemporaryFile() {
        return getFile(TEM_FILE_NAME);
    }

    public File getResultFile(String name) {
        return getFile(name);
    }

    public File getFile(final String filename) {
        File movieFolder = new File(conf().folder());
        final String name = filename + "_recording_" + DateUtils.formatDate(new Date(), "yyyy_dd_MM_HH_mm_ss");
        nameToFfmpeg = name;
        return new File(movieFolder + File.separator + name + EXTENSION);
    }

    private String getScreenSize() {
        Dimension dimension = conf().screenSize();
        return "1920" + "x" + "1040";
    }
}
