package  
{
	import flash.display.MovieClip;
	import flash.events.*;
	import flash.ui.Keyboard;
	
	public class Car extends MovieClip
	{
		var dir   : String;
		var trigx : Number = 0;
		var trigy : Number = 0;
		
		public var  steering     : Number = 10;
		public var  acceleration : Number = 1;
		public var  velocity     : Number = 1;
		public var  gas          : int    = 500;
		
		public function Car() 
		{
			trace("car constructor call");
			this.height = 50;
			this.width  = 50;
			if (gas > 0)
			this.addEventListener(Event.ENTER_FRAME, Go);
		}
		
		function Go(e:Event) : void
		{
			this.x += trigx * this.velocity;
			this.y += trigy * this.velocity;
			this.Limits();
		}

		function Limits() : void
		{
			if (this.x > stage.stageWidth)
			{
				this.x = 0 - this.width;
			}
			
			if (this.x < 0 - this.width)
			{
				this.x = stage.stageWidth;
			}
			
			if (this.y > stage.stageHeight + (this.height/2))
			{
				this.y = 0 - (this.height/2);
			}
			
			if (this.y < 0 - (this.height/2))
			{
				this.y = stage.stageHeight;
			}

		
		}
		
		public function CarRotate(turn : Number) : void
		{
			if (gas > 0)
			{
				if (turn == 0)
				{
					this.rotation += this.steering;	
				}
				else if (turn == 1)
				{
					this.rotation -= this.steering;
				}
				else if (turn == 2)
				{
					trigx = Math.cos(this.rotation * Math.PI/180);
					trigy = Math.sin(this.rotation * Math.PI/180);
				}
				
				trigx = Math.cos(this.rotation * Math.PI/180);
				trigy = Math.sin(this.rotation * Math.PI/180);
			}
		}
		
		public function Fuel() : void
		{
			trace(gas);
			
			if (gas > 0)
			{
				gas -= (0.1 + velocity/100);
			}
			else if (velocity > 0)
			{
				velocity -= 1;
			}
		}
	}
}
