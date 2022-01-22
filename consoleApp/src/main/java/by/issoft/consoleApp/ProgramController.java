package by.issoft.consoleApp;

import by.issoft.domain.Store;
import by.issoft.store.handlers.quit.QuitCommand;
import by.issoft.store.handlers.quit.QuitProgramException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("program/")
public class ProgramController {
    private final QuitCommand quitCommand;
    private final ApplicationContext ctx;

    @PostMapping("exit")
    public void turnOffProgram() {
        try {
            quitCommand.execute(new Store());
        } catch (QuitProgramException e) {
            log.info(e.getMessage());
        }
        ((ConfigurableApplicationContext) ctx).close();
        System.exit(0);
    }
}
