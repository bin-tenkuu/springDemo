package test.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author bin
 * @since 2024/05/11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/File")
public class FileController {

    @PostMapping
    public ResponseEntity<Resource> file() {
        val target = new File("test.xlsx");
        String contentDisposition = ContentDisposition
                .builder("attachment")
                .filename(target.getName())
                .build().toString();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .contentLength(target.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(target));
    }

}
