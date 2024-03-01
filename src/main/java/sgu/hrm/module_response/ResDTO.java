package sgu.hrm.module_response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ResDTO<T> {
    final int status_code;
    final String message;
    final T data;
    final LocalDateTime time_stamp;

    private ResDTO(ResEnum resEnum) {
        this.status_code = resEnum.getStatusCode();
        this.message = resEnum.name();
        this.data = null;
        this.time_stamp = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }

    private ResDTO(ResEnum resEnum, T data) {
        this.status_code = resEnum.getStatusCode();
        this.message = resEnum.name();
        this.data = data;
        this.time_stamp = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }

    public ResDTO(int status_code, ResEnum message, T data, LocalDateTime timeStamp) {
        this.status_code = status_code;
        this.message = message.name();
        this.data = data;
        this.time_stamp = timeStamp;
    }

    public static <T> ResDTO<T> response(ResEnum resEnum, T data) {
        return new ResDTO<>(resEnum, data);
    }

    public static RuntimeException resErrors(ResEnum resEnum) {
        return new RuntimeException(String.valueOf(new ResDTO<>(resEnum)));
    }
}
