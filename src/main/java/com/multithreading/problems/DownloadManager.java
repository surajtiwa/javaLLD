package com.multithreading.problems;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadManager {
    private ExecutorService executorService;
    private String fileUrl;


    public DownloadManager(int threadPoolSize) {
        executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void downloadFiles(List<String> fileUrls) {
        for (String fileUrl : fileUrls) {
            DownloadTask downloadTask = new DownloadTask(fileUrl);
            executorService.submit(downloadTask);
        }

    }


// TODO: Implement a method to track and display the progress of each download


    public void shutdown() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        DownloadManager downloadManager = new DownloadManager(5);
        List<String> filesToDownload = Arrays.asList("file1", "file2", "file3", "file4",
                "file5");
        downloadManager.downloadFiles(filesToDownload);
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread is doing some work...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        downloadManager.shutdown();

    }

}

class DownloadTask implements Runnable {

    String fileUrl;

    DownloadTask(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        System.out.println("Downloading file from url" + fileUrl);
        for (int i = 0; i < 100; i+=10) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Download complete for: " + fileUrl);
    }


}
