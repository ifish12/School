package
{
	import flash.display.MovieClip;
	
	public class docclass extends MovieClip
	{
		// Create a variable called Ferrari in the class level scope that is of type Car
		var Ferrari:Car;
		var Score:Number; // In Flash the type followes the colon
		
		var CarArray:Array = new Array;
		
		public function docclass()
		{
			trace("Yahoo!!");
			trace("Document constructor called");
			
			
			/*Ferrari = new Car;
			Ferrari.x = 200;
			Ferrari.y = 200;
			Ferrari.alpha *= .5;
			stage.addChild(Ferrari);*/
			
			for (var i : Number = 0 ; i < 25; i++)
			{
				CarArray[i] = new Car;
				stage.addChild(CarArray[i]);
			}
				
		
			
		}
		
	}
}