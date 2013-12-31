package  {
	import flash.display.MovieClip;
	
	public class chickenclass extends MovieClip{

		public function chickenclass() {
			// constructor code
		}
		public function setSpecs(sw:Number, sh:Number)
		{
			trace("Made Chicken Specs");
			this.x = Math.floor(Math.random() * (sw - (sw/2) + 1)) + (sw/2);
			this.y = Math.floor(Math.random() * (sh - (sh/2) + 1)) + (sh/2);
			this.scaleX = .1;
			this.scaleY = .1;
		}

	}
	
}
