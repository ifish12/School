package  {
	
	import flash.display.MovieClip;
	import flash.events.*;
	import flash.ui.Keyboard;
	import flash.text.TextField;
	
	
	
	public class docclass extends MovieClip {
		
		var myShooter      : shooter = new shooter;
		var bulletArray    : Array   = new Array();
		var neckbeardArray : Array   = new Array();
		
		
		public function docclass() {
			// constructor code
			
			trace ("docclass running");
			
			myShooter.x = 400;
			myShooter.y = 800;
			
			stage.addChild(myShooter);
			
			stage.addEventListener(KeyboardEvent.KEY_DOWN, DoStuff);
			stage.addEventListener(Event.ENTER_FRAME, HitTest);
			for (var b in bulletArray)
				if( bulletArray[b].y < 0)
				{
					removeChild(bulletArray[b]);	//remove the obstacle from the stage
					trace ("Abote to remove");
					delete bulletArray[b];	//remove the obstacle subscript
				}
					
			
		}
		
		public function HitTest(e:Event): void
		{
			for (var q in bulletArray)
			{
				for (var n in neckbeardArray)
				{
					trace("n is " + n);
					
					//if he car has hit an object and killme is false, show explosion
					if (bulletArray[q].hitTestObject(neckbeardArray[n]) && !neckbeardArray[n].killme)
					{
						neckbeardArray[n].gotoAndPlay("expl");
						trace("hit part of if statement"+neckbeardArray[n].killme);
						
					}
					if (neckbeardArray[n].killme)	//has the explosion appeared?
					{
						trace("in the true killme part about to delete the obstacle"+neckbeardArray[n].killme);
						removeChild(neckbeardArray[n]);	//remove the obstacle from the stage
						delete neckbeardArray[n];	//remove the obstacle subscript
					}
				}
			}
		}
		public function DoStuff(e : KeyboardEvent) : void
		{
			var k = e.keyCode;
			
		
			switch(k)
			{
				case Keyboard.RIGHT:
					myShooter.x += 10;
					break;
					
				case Keyboard.LEFT:
					myShooter.x -= 10;
					break;
				case Keyboard.SPACE:
					var tempOb : bullet = new bullet(myShooter.x, myShooter.y);
				    bulletArray.push(tempOb);	//add the obstacle to the top of the array
				    addChild(tempOb);
					break;
				case Keyboard.B:
					var tempEN : Alien = new Alien(stage.stageWidth, stage.stageHeight);
				    neckbeardArray.push(tempEN);	//add the obstacle to the top of the array
				    addChild(tempEN);
					break;
				
			}
			
		}
		
	}
	
}
