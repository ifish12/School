package  
{
	import flash.display.MovieClip;
	
	public class obstacleClass extends MovieClip
	{
		public var killme : Boolean = false;
		public var dying  : Boolean = false;
		public function obstacleClass(stagex:Number, stagey:Number) 
		{
			this.x = Math.floor(Math.random() * stagex);
			this.y = Math.floor(Math.random() * stagey);
		}
	}
}