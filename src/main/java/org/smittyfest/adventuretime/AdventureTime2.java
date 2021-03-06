package org.smittyfest.adventuretime;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author smittyfest
 */
public class AdventureTime2 extends Application {
  private static final int HORIZONTAL_MOVE_INCREMENT = 8;
  private static final int VERTICAL_MOVE_INCREMENT = 12;

  private static final int TOP_OF_FRAME_BARRIER = 12;
  private static final int BOTTOM_OF_FRAME_BARRIER = 641;

  private static final int LEFTMOST_FRAME_BARRIER = 2;
  private static final int RIGHTMOST_FRAME_BARRIER = 630;

  private static final int OVERWORLD_MAP_WIDTH = 1001;
  private static final int OVERWORLD_MAP_HEIGHT = 443;

  private static final int OVERWORLD_MAP_ROWS = (OVERWORLD_MAP_HEIGHT / VERTICAL_MOVE_INCREMENT);
  private static final int OVERWORLD_MAP_COLUMNS = (OVERWORLD_MAP_WIDTH / HORIZONTAL_MOVE_INCREMENT);

  private static final String FONTSTYLE = "Courier";
  private static final int FONTSIZE = 14;
  private static final int FONT_PLAIN = 0;
  private static final int MAX_COLOR_VALUE = 16777215;

  private static final Random random = new Random();

  public void start(Stage primaryStage) throws Exception {
    GridPane board = new GridPane();

    for (int colCoord = LEFTMOST_FRAME_BARRIER, col = 0; col < OVERWORLD_MAP_COLUMNS; ++col, colCoord += HORIZONTAL_MOVE_INCREMENT) {
      for (int rowCoord = TOP_OF_FRAME_BARRIER, row = 0; row < OVERWORLD_MAP_ROWS; ++row, rowCoord += VERTICAL_MOVE_INCREMENT) {
        Text text = new Text("§");
        text.setLayoutY(rowCoord);
        text.setLayoutX(colCoord);
        text.setFill(generateColor());
        text.setFont(Font.font("Courier", FontWeight.BOLD, 16));
        board.add(text, colCoord, rowCoord);
      }
    }
    Scene scene = new Scene(board, 1010, 384);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String [] args) {
    Application.launch(args);
  }
  private Color generateColor() {
    return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
  }
}
