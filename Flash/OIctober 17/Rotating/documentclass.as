package
{
	import flash.display.MovieClip;
	import flash.ui.Keyboard;
	import flash.events.*;
	
	public class documentclass extends MovieClip
	{
		
		var myCar:Car = new Car();		
		
		public function documentclass()
		{
			trace("Document class constructor called");
			
			myCar.x = stage.stageWidth/2;
			myCar.y = stage.stageHeight/2;
			
			stage.addChild(myCar);
			stage.addEventListener(KeyboardEvent.KEY_DOWN, processKey)
			
			/*
			rbtn.addEventListener(MouseEvent.CLICK, rightBtn)
			ubtn.addEventListener(MouseEvent.CLICK, upBtn)
			dbtn.addEventListener(MouseEvent.CLICK, downBtn)*/
			
		}
		
		private function processKey(e:KeyboardEvent):void
		{
			var key = e.keyCode;
			
			switch(key)
			{
				case Keyboard.RIGHT:
					myCar.myRotate(0);
					break;
				case Keyboard.LEFT:
					myCar.myRotate(1);
					break;
				case Keyboard.UP:
					myCar.Speed += myCar.acceloration;
					myCar.myRotate(2);
					break;
				case Keyboard.DOWN:
					myCar.Speed += myCar.decceloration;
					myCar.myRotate(2);
					break;
			}
		}
	}
}