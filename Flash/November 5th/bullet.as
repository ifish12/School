package  {
	
	import flash.display.MovieClip;
	import flash.events.*;
	import flash.ui.Keyboard;
	import flash.text.TextField;
	
	
	public class bullet extends MovieClip {
		public var going : Boolean = false;
		
		public function bullet(x:int, y:int)
		{
			trace ("Bullet being primmed!");
			this.x = x;
			this.y = y;
			
			addEventListener(Event.ENTER_FRAME, MoveHit);
		}
		private function MoveHit(e:Event) : void
		{
				this.y -= 17;
		}
		
	}
	
}
