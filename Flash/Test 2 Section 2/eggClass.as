package  {
	
	import flash.display.MovieClip;
	import flash.ui.Mouse;
	import flash.ui.Keyboard;
	import flash.events.*;
	
	
	public class eggClass extends MovieClip {
		
		public var HP        : int = new int();
		var initialHP : int = new int();
		public function eggClass(thisx:int, thisy:int) 
		{
			// constructor code
			trace ("Egg's being made");
			this.x = thisx;
			this.y = thisy;
			
			initialHP = Math.floor(Math.random() * (5 - 2) + 3);
			HP = initialHP;
			rndNumb.visible = true;
			rndNumb.text = HP.toString();
			addEventListener(Event.ENTER_FRAME, LowerHP);

		}
		public function LowerHP(e:Event)
		{
			rndNumb.text = HP.toString();
			
		}
	}
	
}
