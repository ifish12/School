package  {
	
	import flash.ui.Mouse;
    import flash.events.MouseEvent;  
	import flash.ui.Keyboard;
    import flash.display.MovieClip;
	import flash.events.*;
	
	
	public class padel extends MovieClip {
		// Keycodes
		var Q:Number = new Number();
		var A:Number = new Number();
		var Down:Number = new Number();
		var Up:Number = new Number();
		var KeyboardPress:Array = new Array();
		

		
		public function padel (up,down) {
			// constructor code
			trace ("Padel constructor called");
			Up = up;
			Down = down;
		
			addEventListener(Event.ENTER_FRAME,mover);
			
		}
		
		private function mover(e:Event):void {
			
			
			if (KeyboardPress[Up] == true)
			{
				trace ("in the handler position 38 is " + KeyboardPress[Up]);
				this.y-=30;
			}
			if (KeyboardPress[Down] == true)
			{
				trace ("in the handler position 40 is " + KeyboardPress[Down]);
				this.y+=30;
			}
		}
		public function getArray(Press) {
			
			KeyboardPress = Press;
		}
	}
	
}
