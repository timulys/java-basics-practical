package study.javaorder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReceiptFileStore {
    private final Path file;

    public ReceiptFileStore(Path file) {
        if (file == null) {
            throw new IllegalArgumentException("저장 경로가 필요합니다.");
        }
        this.file = file;
    }

    public void save(String summary) throws IOException {
        Path parent = file.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.writeString(file, summary, StandardCharsets.UTF_8);
    }

    public String read() throws IOException {
        return Files.readString(file, StandardCharsets.UTF_8);
    }
}
