package
{
	import flash.display.MovieClip;
	import flash.events.*;		//for all events, including MouseEvent and Event
	
	public class Car extends MovieClip
	{
		private var trigx:Number = 0;//Math.cos(this.rotation*Math.PI/180);
		private var trigy:Number = 0;//Math.sin(this.rotation*Math.PI/180);
		
		var Speed:Number = 2;
		var steeringfactor:Number = 3;
		var acceloration:Number = 1;
		var decceloration:Number = -0.5;
		
		public function Car()
		{
			trace("Car constructor called!");
			this.addEventListener(Event.ENTER_FRAME, go);		//this is called automatically every frame!
		}	// end of car default constructor
		
		public function go(e:Event):void
		{			
			this.x += trigx * this.Speed;
			this.y += trigy * this.Speed;
			
			this.limit();
		}
		public function limit():void
		{
			if (this.x > stage.stageWidth)
				this.x = 0 - this.width;
			
			if (this.x < 0 - this.width)
				this.x = stage.stageWidth;
			
			if (this.y > stage.stageHeight)
				this.y = 0 - this.height;
			
			if (this.y < 0 - this.height)
				this.y = stage.stageHeight;

		}
		
		public function myRotate(turn:Number):void
		{
			if (turn == 0)
			{
				this.rotation += this.steeringfactor;
				trigx= Math.cos(this.rotation*Math.PI/180);
				trigy= Math.sin(this.rotation*Math.PI/180);
			}
			else if (turn == 1)
			{
				this.rotation -= this.steeringfactor;
				trigx= Math.cos(this.rotation*Math.PI/180);
				trigy= Math.sin(this.rotation*Math.PI/180);
			}
			else if (turn == 2)
			{
				trigx= Math.cos(this.rotation*Math.PI/180);
				trigy= Math.sin(this.rotation*Math.PI/180);
			}
			
			
		}
	}	//end of class
}	// end of package
