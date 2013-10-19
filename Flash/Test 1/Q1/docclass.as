package
{
	import flash.events.MouseEvent;
	import flash.display.MovieClip;
	import flash.display.SimpleButton;
	import flash.display.Sprite;
	
	
	public class docclass extends MovieClip 
	{
		var Scanner:symScanner = new symScanner; 
		public function docclass()
		{
			
		    var btnArcBlue:btnStart = new btnStart;
		    var btnArcGreen:btnStop = new btnStop;
			trace("Docclass constructor created!!");
			
   			this.stop();
			
			//var btnArcGreen:btnMovingDown = new btnMovingDown; 
			
			
			
			//Scanner.x =0;
			//Scanner.y = 0;
			
		    btnArcBlue.x =550;
			btnArcBlue.y = 550;
			
			btnArcGreen.x = 100;
			btnArcGreen.y = 500;
			
			//stage.addChild(Scanner);
			stage.addChild(btnArcBlue);
			stage.addChild(btnArcGreen);
			
			
			btnArcBlue.addEventListener(MouseEvent.CLICK, ClickHandlerSTART);
			btnArcGreen.addEventListener(MouseEvent.CLICK, ClickHandlerSTOP);

			

		}
	     function ClickHandlerSTART(e:MouseEvent):void
		 {
				trace("Starting");
				
				this.play();
		 }
		 
		  function ClickHandlerSTOP(e:MouseEvent):void
		 {
				trace("Stopping");
				
				this.stop();
		 }
	}
}