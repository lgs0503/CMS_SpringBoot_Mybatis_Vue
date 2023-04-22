package com.gs.bbs.file;

import com.gs.bbs.api.file.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class FileTest {

    private final FileService fileService;
    private final MockMvc mockMvc;

    @Autowired
    public FileTest(FileService fileService, MockMvc mockMvc) {
        this.fileService = fileService;
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("파일 업로드")
    public void uploadFile() throws Exception {

        String filePath = "C://uploads/test/공부.txt";
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

        MockMultipartFile file = new MockMultipartFile("files", "공부.txt", "text/plain", fileContent);

        mockMvc.perform(multipart("/file")
                        .file(file))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("파일 다운로드")
    public void downloadFile(){

    }

    @Test
    @DisplayName("이미지 파일 인코더")
    public void imageEncoder(){

        String encodingFile = fileService.imageEncoder(1);

        log.info("imageEncoder : " + encodingFile);

    }
}
