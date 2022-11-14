package logic.init;

import io.qameta.allure.Step;

public class LogToAllure {
        @Step("{0}")
        public static void logToAllure (String message, String log){}
}
