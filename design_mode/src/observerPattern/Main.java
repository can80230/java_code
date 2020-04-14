package observerPattern;

public class Main {

	public static void main(String[] args) {
		VideoSite vs = new VideoSite();
		vs.registerObserver(new VideoFans("LiLei"));
		vs.registerObserver(new VideoFans("HanMeiMei"));
		vs.registerObserver(new VideoFans("XiaoMing"));
		
		vs.addVideos("The Big Bang Theory");
	}

}
