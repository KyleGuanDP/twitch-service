package com.laioffer.twitch;

import com.laioffer.twitch.item.ItemController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final ItemController itemController;

    // Spring 会自动注入 ItemController
    public TestRunner(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public void run(String... args) {
        System.out.println(">>> TestRunner started");

        // 检查 ItemController 是否成功注入
        if (itemController != null) {
            System.out.println(">>> TestRunner: ItemController bean exists");
        } else {
            System.out.println(">>> TestRunner: ItemController bean is null!");
        }

        // 可调用方法测试
        try {
            String pingResult = itemController.ping();
            System.out.println(">>> TestRunner: ping() returns -> " + pingResult);
        } catch (Exception e) {
            System.out.println(">>> TestRunner: ping() call failed: " + e.getMessage());
        }
    }
}
