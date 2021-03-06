package ui.base;


import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;
import scene.Setting;


public class MenuSubscene extends SubScene{

	private boolean isHidden ;
	
	public MenuSubscene(int h,int w) {
		super(new AnchorPane(),h,w);
		prefWidth(w);
		prefHeight(h);
		BackgroundImage imageBackground = new BackgroundImage(
				new Image(ClassLoader.getSystemResource("grey_panel.png").toString(), h, w,
						false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		AnchorPane root = (AnchorPane) this.getRoot();
		root.setBackground(new Background(imageBackground));
		isHidden = true;
		setLayoutX(Setting.GAME_WIDTH + w);
		setLayoutY(50);
	}

	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		if (isHidden) {
			//System.out.println(-Setting.GAME_WIDTH - this.getWidth() + ((Setting.GAME_WIDTH - this.getWidth()) / 2));
			transition.setToX(-Setting.GAME_WIDTH - this.getWidth() + ((Setting.GAME_WIDTH - this.getWidth()) / 2));
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		transition.play();
	}

	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

	public boolean isHidden() {
		return isHidden;
	}
	
	
}
