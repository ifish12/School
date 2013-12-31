 package  {
	import flash.display.MovieClip;
	import flash.events.*;
	import flash.ui.Keyboard;
	import flash.text.TextField;
	
	
	
	public class docclass extends MovieClip
	{
		var myCar     : Car = new Car;
		var turn      : Number;		//if turn is 0, car rotates right, 1 rotates left, 2 accelerates
		var obsArray  : Array = new Array(); //dynamic array of obstacles
		var numObs    : Number = 5;
		var gasText   : TextField = new TextField;
		var charArray : Array = new Array(4);
		var i         : uint;
		
		public function docclass() 
		{	
		trace ("does this work");
			for (i = 0; i < 4; i++)
			{
				charArray[i] = Boolean(false);
			}
		
			myCar.x = 0; + (myCar.width/2);
			myCar.y = stage.stageHeight - (myCar.height/2);
			stage.addChild(myCar);
			
			gasText.height = 40;
			gasText.width  = 150;
			gasText.x = 20;
			gasText.y = 10;
			gasText.scaleY = 1.5;
			stage.addChild(gasText);
			
			stage.addEventListener(KeyboardEvent.KEY_DOWN, Processkey);
			stage.addEventListener(Event.ENTER_FRAME, HitTest);
			
			for (var i = 0; i < numObs; i++)
			{
				var tempOb : obstacleClass = new obstacleClass(stage.stageWidth, stage.stageHeight);
				obsArray.push(tempOb);	//add the obstacle to the top of the array
				addChild(tempOb);
			}
		}
		
		private function Frame(e:Event) : void
		{
			if (myCar.gas > 0 && charArray[0])		
			{
				turn = 0;
				myCar.CarRotate(turn);
			}
		}
		
		private function Processkey(e : KeyboardEvent) : void
		{
			var k = e.keyCode;
			
			switch(k)
			{	//as long as gas is greater than 0, allow these functions
				case Keyboard.RIGHT:		
					turn = 0;
					myCar.CarRotate(turn);
					break;
			
				case Keyboard.LEFT:
					if (myCar.gas > 0)
					{
						turn = 1;
						myCar.CarRotate(turn);
					}
					trace("keyboard left");
					break;
					
				case Keyboard.UP:
					if (myCar.gas > 0)
					{	
						turn = 2;
						myCar.velocity += myCar.acceleration;
						myCar.CarRotate(turn);
					}
					trace("keyboard up");
					break;
					
				case Keyboard.DOWN:
					if (myCar.velocity > 0)
					{
						turn = 2;
						myCar.velocity -= myCar.acceleration;
						myCar.CarRotate(turn);
					}
					trace("keyboard down");
					break;
				//hitting space will create a new randomly placed obstacle	
				case Keyboard.SPACE:
					var tempOb : obstacleClass = new obstacleClass(stage.stageWidth, stage.stageHeight);
					obsArray.push(tempOb);
					addChild(tempOb);
			}
		}
		
		private function HitTest(e:Event) : void
		{
			
			
			for (var n in obsArray)
			{
				trace("n is " + n);
				
				//if he car has hit an object and killme is false, show explosion
				if (myCar.hitTestObject(obsArray[n]) && !obsArray[n].dying)
				{
					obsArray[n].gotoAndPlay("expl");
					trace("hit part of if statement" + obsArray[n].dying);
					
				}
				if (obsArray[n].killme)	//has the explosion appeared?
				{
					trace("in the true killme part about to delete the obstacle"+obsArray[n].killme);
					removeChild(obsArray[n]);	//remove the obstacle from the stage
					trace ("Abote to remove");
					delete obsArray[n];	//remove the obstacle subscript
					trace ("Deleting?");
				}
			}
			myCar.Fuel();
			gasText.text = "Remaining Gas: " + myCar.gas.toString();
		}
	}
}