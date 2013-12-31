package  {
	import flash.display.MovieClip;
	public class eggclass extends MovieClip{
		public function eggclass() {

		}
		public function setSpecs(xc:Number, yc:Number)
		{
			this.x = xc;
			this.y = yc;
			this.scaleX = .3;
			this.scaleY = .3;
		}
	}
}
