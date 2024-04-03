package com.project.splitwise;

import commands.Command;
import commands.CommandExecutor;
import commands.CreateCommandUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties
@EntityScan(basePackages = {"models"})
@ComponentScan(basePackages = {"commands","controller","services"})
@EnableJpaRepositories(basePackages = {"repositories"})
public class SplitwiseApplication implements CommandLineRunner {

    private Scanner scanner;
    private CommandExecutor commandExecutor;

    public SplitwiseApplication(CommandExecutor commandExecutor, List<Command> command){

        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
        this.commandExecutor.addCommand(command);
    }
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true) {
            System.out.println("Enter input: ");
            String input = scanner.nextLine();
            System.out.println("User entered: " + input);
            commandExecutor.execute(input);
        }
    }
}
