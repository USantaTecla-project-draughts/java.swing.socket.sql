package usantatecla.draughts.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {

    @Mock
    private Console console;

    @Mock
    private ResumeController resumeController;

    private ResumeView resumeView;

    @BeforeEach
    public void beforeEach(){
        this.resumeView = new ResumeView();
    }

    @Test
    public void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("n");
            assertThat(this.resumeView.interact(this.resumeController), is(false));
        }
    }

    @Test
    public void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("y");
            assertThat(this.resumeView.interact(this.resumeController), is(true));
        }
    }

}
