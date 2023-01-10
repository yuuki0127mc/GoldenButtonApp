// レポート第1回: Golden Button Application
package ex05;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GoldenButtonApp extends Application {

    public static String gakuban = ""; // 学籍番号を入力すること
    public static String yourname = ""; // 氏名を入力すること

    Scene scene1, scene2, scene3;
	Label label1, label2, label3;
	Stage stage;
	boolean flag = true;
	int b =0;//scene1でどのボタンを押したか
	int color = 0;//scene1でどの色を選択したか
    @Override
    public void start(Stage primaryStage) {
        // プログラムを作成
    	stage = primaryStage;
    	
    	//Scene1 落とした斧
    	
    	label1 = new Label("あなたが落としたのはどの斧ですか？");
    	label1.setPrefHeight(20);
    	label1.setFont(new Font (15));
    	Button button11 = new Button("金");
    	button11.setOnAction(e -> btn1act(1));
    	button11.setPrefWidth(50);//ボタンの幅変更
    	button11.setPrefHeight(50);//ボタンの高さ変更
    	button11.setFont(new Font (15));
    	Button button12 = new Button("銀");
    	button12.setOnAction(e -> btn1act(2));
    	button12.setPrefWidth(50);
    	button12.setPrefHeight(50);
    	button12.setFont(new Font (15));
    	Button button13 = new Button("銅");
    	button13.setOnAction(e -> btn1act(3));
    	button13.setPrefWidth(50);
    	button13.setPrefHeight(50);
    	button13.setFont(new Font (15));

    	
    	//ボタンを横表示
    	HBox pane1h = new HBox(30,button11,button12,button13);
    	pane1h.setAlignment(Pos.CENTER);
    	
    	//VBoxへの組み込み
    	VBox pane1v = new VBox(30,label1,pane1h);
    	pane1v.setAlignment(Pos.CENTER);
    	scene1 = new Scene(pane1v,300,200);

    	//Scene2 答え
    	Button button21 = new Button("はい");
    	button21.setOnAction(e -> btn2act(1));
    	button21.setPrefWidth(50);//ボタンの幅変更
    	button21.setPrefHeight(50);//ボタンの高さ変更
    	button21.setFont(new Font (11));
    	
    	Button button22 = new Button("いいえ");
    	button22.setOnAction(e -> btn2act(2));
    	button22.setPrefWidth(50);//ボタンの幅変更
    	button22.setPrefHeight(50);//ボタンの高さ変更
    	button22.setFont(new Font (11));
    	
    	//ボタンを横表示
    	HBox pane2h = new HBox(30,button21,button22);
    	pane2h.setAlignment(Pos.CENTER);
    	
    	//VBoxへの組み込み
    	label2 = new Label();
    	label2.setPrefHeight(20);
    	label2.setFont(new Font (15));
    	VBox pane2v = new VBox(30,label2,pane2h);
    	pane2v.setAlignment(Pos.CENTER);
    	
    	scene2 = new Scene(pane2v,300,150);
    	
    	//Scene3 結末
    	
    	Button button31 = new Button("最初に戻る");
    	
    	button31.setOnAction(e -> {
    		b = 0;
    		flag = true;
    		stage.setScene(scene1);
    	});
    	button31.setPrefWidth(90);//ボタンの幅変更
    	button31.setPrefHeight(50);//ボタンの高さ変更
    	button31.setFont(new Font (15));
    	Button button32 = new Button("終わり");
    	button32.setOnAction(e -> finish());
    	button32.setPrefWidth(90);//ボタンの幅変更
    	button32.setPrefHeight(50);//ボタンの高さ変更
    	button32.setFont(new Font (15));
    	
    	//ボタンの横表示
    	HBox pane3h = new HBox(30,button31,button32);
    	pane3h.setAlignment(Pos.CENTER);
    	
    	//VBoxへの組み込み
    	label3 = new Label();
    	label3.setFont(new Font (15));
    	VBox pane3v = new VBox(30,label3,pane3h);
    	pane3v.setAlignment(Pos.CENTER);
    	
    	scene3 = new Scene(pane3v,300,150);
    	
    	//装飾
    	button11.setTextFill(Color.GOLD);
    	button12.setTextFill(Color.GRAY);
    	button13.setTextFill(Color.rgb(129, 90, 43));
    	button21.setTextFill(Color.GREEN);
    	button22.setTextFill(Color.RED);
    	
    	
    	stage.setScene(scene1);
    	stage.setTitle("GoldenButtonApp");
    	stage.show();
    }
    
    //メソッド
    //btn1act
    public void btn1act(int num) {
    	b++;
    	color = num;
    	label2set(b);
    	stage.setScene(scene2);
    }
    //label2set Scene2での問題文
    public void label2set(int b) {
    	if(b == 1) {
    		label2.setText("あなたが落としたのは金の斧ですか？");
    	}
    	else if(b == 2) {
    		label2.setText("あなたが落としたのは銀の斧ですか？");
    	}
    	else if(b == 3) {
    		label2.setText("あなたが落としたのは銅の斧ですか？");
    	}
    }
    
    //btn2act　嘘の判定
    public void btn2act(int num) {
    	switch(num) {
    	case 1:
    		if(b != color)flag = false;
    		break;
    	case 2:
    		if(b == color)flag = false;
    		break;
    		
    	}
    	
    	if(b == 3) {
    		label3set();
    		stage.setScene(scene3);
    	}
    	else {
    		b++;
    		label2set(b);
    	}
    }
    
    //label3set 結果の表示
    public void label3set() {
    	if(flag)
    		goodvoice();
    	else
    		badvoice();
    }
    
    //正直者へのコメントのランダム表示
    public void goodvoice() {
    	
    	String[]str = {"あなたは正直者ですな！","素晴らしい！","正直者にはこの斧、全部差し上げます！"};
    	int ran = (int)(Math.random()*(str.length));
    	label3.setText(str[ran]);
    }
    
    //嘘つきへのコメントのランダム表示
    public void badvoice() {
    	
    	String[]str = {"嘘ついたな...呪ってやる...","嘘つき！！","YOU ARE DEAD","FATALITY"};
    	
    	int ran = (int)(Math.random()*(str.length));
    	label3.setText(str[ran]);
    }
    
    //finish 終了ボタンでのアラート表示
    public void finish() {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"斧落としたりなくないですか？");
    	Optional opt = alert.showAndWait();
    	if(opt.isPresent() && opt.get().equals(ButtonType.OK)) {
    		stage.close();
    	}
    }
    
    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--GoldenButtonApp");
    }

}

/* 考察 -- 調査したこと、工夫したこと、確認したことを記述
今回の課題で工夫したことは主にある。
一点目は、嘘をついたの判定方法だ。斧の色一つ一つに番号を与え、かつにもscene1の選択肢にも番号を与え、その番号の一致するか否かで嘘かどうか判定する方法を用いた。また選択肢に番号を振ることで、三回の質問をすべて行うようにした。
二点目は結果でのコメントをランダムで表示させることだ。配列に複数のコメントを作製し、乱数を用い配列の中身を呼び出す仕組みにした。
三点目は装飾だ。ボタンとフォントの色と大きさを分かりやすく使いやすいものし変更した。またそれに伴い新しいimport文を調査した。
四点目はAlert文だ。「終わり」を押した際に、プログラムを終了させてよいかの確認をするメソッドを作った。
 */
