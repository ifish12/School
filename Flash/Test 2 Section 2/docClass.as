package  
{
	
	import flash.display.MovieClip;
	import flash.ui.Mouse;
	import flash.ui.Keyboard;
	import flash.events.*;
	
	
	
	public class docClass extends MovieClip 
	{
		
		var myChicken: chickenClass = new chickenClass();
		var eggsArray : Array = new Array(); 
		
		public function docClass() 
		{
			// constructor code
			
			trace ("docClass has been called successfully!");
			myChicken.setArea(stage.stageWidth,stage.stageHeight);
			//myChicken.startDrag(true);  // Code to make the chicken follow the mouse
			Mouse.hide();  // Code to hide the mouse
			stage.addChild(myChicken);
			
			stage.addEventListener(MouseEvent.MOUSE_DOWN, processClickDOWN);
			stage.addEventListener(MouseEvent.MOUSE_UP, processClickUP);
			stage.addEventListener(KeyboardEvent.KEY_DOWN, processKeyboard);
			stage.addEventListener(Event.ENTER_FRAME, HitTest);

			
			
		}
		public function processClickDOWN(e:MouseEvent) : void
		{
			if (MouseEvent.MOUSE_DOWN)
				myChicken.startDrag(true);  // Code to make the chicken follow the mouse
		
			
		}
	    public function processClickUP(e:MouseEvent) : void
		{
			myChicken.stopDrag();  // Code to make the chicken follow the mouse
		}
		
		private function HitTest(e:Event) : void
		{
			
			for (var n in eggsArray)
			{
				trace("n is " + n);
				
				//if he car has hit an object and killme is false, show explosion
				if (myChicken.hitTestObject(eggsArray[n]))
				{
					eggsArray[n].HP--;
					trace("hit part of if statement"+eggsArray[n].HP);
					
				}
				if (eggsArray[n].HP <= 0)	//has the explosion appeared?
				{
					//trace("in the true killme part about to delete the obstacle"+eggsArray[n].HP);
					removeChild(eggsArray[n]);	//remove the obstacle from the stage
					delete eggsArray[n];	//remove the obstacle subscript
				}
			}
		
		}
		
		private function processKeyboard(e:KeyboardEvent):void
		{
			trace("ProcessKeyboard");
			var k = e.keyCode;
			switch(k)
			{
				case (Keyboard.SPACE):
				{
					myChicken.stopDrag();
					LayTheEgg();
					
				}
				break;
			}
		}
		private function LayTheEgg()
		{
			var tempOb : eggClass = new eggClass(myChicken.x, myChicken.y);
			eggsArray.push(tempOb);
			stage.addChild(tempOb);
		}
	}
	
}
