package
{
	import flash.display.MovieClip;
	
	public class Car extends MovieClip
	{
		public function Car()
		{
			// Default car constructor
			trace("Car constructor called");
			trace ("Setting X and Y");
			
			var dx, dy:Numberl
			
			dx = Math.random()*550;
			dy = Math.random()*400;
			
			trace ("setting x and y" +dx + "  and " +dy);
			
			this.x = dx;
			this.y = dy;
							   
		}
		
	}
	
}