package  {
	
	import flash.display.MovieClip;
	import flash.events.*;
	import flash.ui.Keyboard;
	import flash.text.TextField;
	
	
	public class Alien extends MovieClip {
		public var killme : Boolean = false;
		
		public function Alien(stagex:Number, stagey:Number) 
		{
			trace("Neckbeard being crying");
			this.x = Math.floor(Math.random() * stagex);
			this.y = Math.floor(Math.random() * stagey);
		}
	}
	
}
