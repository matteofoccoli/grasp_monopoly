import com.example.monopoly.Board;
import com.example.monopoly.Cup;
import com.example.monopoly.Player;
import com.example.monopoly.Square;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by matteo on 03/09/14.
 */
public class PlayerTest {

  @Test
  public void takesATurn() throws Exception {
    Cup cup = mock(Cup.class);
    Board board = mock(Board.class);
    Square square = mock(Square.class);
    when(cup.getValue()).thenReturn(10);
    when(board.getSquare(any(Square.class), eq(10))).thenReturn(square);

    Player player = new Player(cup, board);
    player.takeTurn();

    verify(cup).roll();
    verify(square).landedOn(eq(player));
    assertThat(player.getCurrentLocation(), equalTo(square));
  }

}
