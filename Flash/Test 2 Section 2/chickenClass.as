package  {
	
	import flash.display.MovieClip;
	import flash.ui.Mouse;
	import flash.ui.Keyboard;
	import flash.events.*;
	
	
	public class chickenClass extends MovieClip {
		
		
		public function chickenClass() 
		{
			trace ("Called Chicken Class");
			
		}
		public function setArea(sw:Number, sh:Number)
		{
			trace("Made Chicken Specs");
			this.x = Math.floor(Math.random() * (sw - (sw/2) + 1)) + (sw/2);
			this.y = Math.floor(Math.random() * (sh - (sh/2) + 1)) + (sh/2);
			this.scaleX = .1;
			this.scaleY = .1;
		}
	}
	
}
