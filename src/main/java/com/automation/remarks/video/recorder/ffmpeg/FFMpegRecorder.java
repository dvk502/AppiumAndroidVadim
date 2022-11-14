package com.automation.remarks.video.recorder.ffmpeg;

import com.automation.remarks.video.recorder.VideoRecorder;
import org.apache.log4j.Logger;
import org.awaitility.core.ConditionTimeoutException;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

/**
 * Created by sepi on 19.07.16.
 */
public abstract class FFMpegRecorder extends VideoRecorder {
    private static final Logger log = org.apache.log4j.Logger.getLogger(FFMpegRecorder.class);

    private FFmpegWrapper ffmpegWrapper;

    public FFMpegRecorder() {
        this.ffmpegWrapper = new FFmpegWrapper();
    }

    public FFmpegWrapper getFfmpegWrapper() {
        return ffmpegWrapper;
    }

    @Override
    public File stopAndSave(final String filename) {
        File file = getFfmpegWrapper().stopFFmpegAndSave(filename);
        waitForVideoCompleted(file);
        setLastVideo(file);
        return file;
    }

    public void waitForVideoCompleted(File video) {
        try {
            await().atMost(20, TimeUnit.SECONDS)
                    .pollDelay(1, TimeUnit.SECONDS)
                    .ignoreExceptions()
                    .until(video::canRead);
        } catch (ConditionTimeoutException ex) {
            log.warn(ex);
            log.info("Completed video not found! Maybe recording has not started, or the video has not been processed to the end");
        }
    }
}
