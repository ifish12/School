package  
{
	import flash.display.MovieClip;
	import flash.ui.Mouse;
	import flash.ui.Keyboard;
	import flash.events.*;
	
	public class docclass extends MovieClip
	{
		trace("Indocclass");
		var chicken:chickenclass = new chickenclass;
		var layingEgg:Boolean = false;
		var counter:Number = 0;
		var eggList:Array = new Array;
		var timerList:Array = new Array;
		var eggCount:Number = 0;
		var counter2:Number = 0;
		
		public function docclass() 
		{
			trace("in constructor");
			chicken.setSpecs(stage.stageWidth,stage.stageHeight);
			chicken.startDrag(true);
			Mouse.hide();
			stage.addChild(chicken);
			stage.addEventListener(KeyboardEvent.KEY_DOWN, processkey);
		}
		private function processkey(e:KeyboardEvent):void
		{
			trace("ProcessKey");
			var k = e.keyCode;
			switch(k)
			{
				case (Keyboard.SPACE):
				{
					layTheEgg();
					chicken.stopDrag();
				}
				break;
			}
		}
		private function layTheEgg()
		{
			counter = 0;
			layingEgg = true;
			addEventListener(Event.ENTER_FRAME, EnterFrame);
			chicken.gotoAndPlay("layegg");
		}
		private function EnterFrame(e:Event)
		{
			counter++;
			if(counter >= 48)
			{
				removeEventListener(Event.ENTER_FRAME, EnterFrame);
				layingEgg = false;
				counter = 0;
				chicken.startDrag(true);
				
				var time:Number = Math.floor(Math.random() * (28 - 12 + 1)) + 12;
				trace("timer:" + time);
				var egg:eggclass = new eggclass;
				egg.setSpecs(chicken.x,chicken.y);
				egg.thenum.text = time.toString();
				stage.addChild(egg);
				timerList.push(time);
				eggList.push(egg);
				eggCount ++;
				addEventListener(Event.ENTER_FRAME, timers);
			}
		}
		private function timers(e:Event)
		{
			if (eggCount > 0 && !layingEgg)
			{
				counter2++;
				if(counter2 >=24)
				{
					counter2 = 0;
					for(var i in timerList)
					{
						timerList[i] -= 1;
						eggList[i].thenum.text = timerList[i].toString();
						if(timerList[i] == 0)
						{
							timerList.splice(i,1);
							stage.removeChild(eggList[i]);
							eggList.splice(i,1);
							eggCount --;
						}
					}
				}
			}
		}
	}
}
