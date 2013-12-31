package  {
	
	import flash.ui.Mouse;
    import flash.events.MouseEvent;  
	import flash.ui.Keyboard;
    import flash.display.MovieClip;
	import flash.events.*;
	import fl.motion.MotionEvent;
	
	
	public class docclass extends MovieClip {
		 
		var RightPaddle:padel         = new padel(38, 40);
		var LeftPaddle:padel          = new padel(81, 65);
		var KeyboardPress:Array       = new Array(255);
		var myBalls:Array             = new Array();
		//var P1Score:TextField         = new TextField;
		//var P2Score:TextField         = new TextField;
		
		var TopWall:Limits            = new Limits();
		var BotWall:Limits            = new Limits();
		
		var v:int                     = new int();
		var magicLeftNumber:Number    = new Number();
		var magicRightNumber:Number   = new Number();
		var theta:int                 = new int();
		var triX:Number               = new Number();
		var triY:Number               = new Number();
		
		var UpperLimit:int            = new int();
		var LowerLimit:int            = new int();
		
		var btnStart:btnClass         = new btnClass();
		var btnStop:btnClass          = new btnClass();

		public function docclass() {
			// constructor code
			v = 27;
			magicLeftNumber = 0.4;
			magicRightNumber = -0.4;
			LeftPaddle.x = 10;
			LeftPaddle.y = 450;
			
			RightPaddle.x = 1490;
			RightPaddle.y = 450;
			
			btnStart.x = 670;
			btnStart.y = 361
			
			btnStop.x = 670;
			btnStop.y = 448;
			
			TopWall.x = 750;
			TopWall.y = 10;
			
			BotWall.x = 750;
			BotWall.y = 900;
			
			
			stage.addChild(btnStop);
			stage.addChild(btnStart);
			/*stage.addChild(RightPaddle);
			stage.addChild(LeftPaddle);
			//stage.addChild(Ball);
			stage.addChild(TopWall);
			stage.addChild(BotWall);
			*/
			
			btnStart.addEventListener(MouseEvent.CLICK, START);
			stage.addEventListener(KeyboardEvent.KEY_DOWN,processDOWN);
			stage.addEventListener(KeyboardEvent.KEY_UP,processUP);
			stage.addEventListener(Event.ENTER_FRAME,HitTest);

		}
		private function START(e:MotionEvent) :void {
			
		}
		private function processDOWN(e:KeyboardEvent):void {
			trace ("Down has been called");
			var k = e.keyCode;
			KeyboardPress[k] = true;
			RightPaddle.getArray(KeyboardPress);
			LeftPaddle.getArray(KeyboardPress);
			
			
			switch(k)
			{
				case Keyboard.B:
					var tempBall : pongball = new pongball(750, 450);
					myBalls.push(tempBall);
					stage.addChild(tempBall);
					break;
			}
		}
		private function processUP(e:KeyboardEvent):void {
			trace ("Up has been called");
			var k = e.keyCode;
			KeyboardPress[k] = false;
			RightPaddle.getArray(KeyboardPress);
			LeftPaddle.getArray(KeyboardPress);
		}
		private function HitTest(e:Event): void {
			
			for (var n in myBalls)
			{
				if ((RightPaddle.hitTestObject(myBalls[n])) || (myBalls[n].x >= RightPaddle.x))
				{
					if (RightPaddle.hitTestObject(myBalls[n]))
						{
							trace ("Ball hit the right paddle");
							theta = RightPaddle.y - myBalls[n].y;
							theta*=magicRightNumber;
							
							triX = Math.cos(theta)*v;
							triY = Math.sin(theta)*v;
							
							myBalls[n].moveCoord(triX, triY);
						}
					
				}
				
				
				if ((LeftPaddle.hitTestObject(myBalls[n])) || (myBalls[n].x <= LeftPaddle.x))
				{
					if (LeftPaddle.hitTestObject(myBalls[n]))
						{
							trace ("Ball hit the left paddle");
							theta = LeftPaddle.y - myBalls[n].y;
							theta*=magicLeftNumber;
							
							triX = Math.cos(theta)*v;
							triY = Math.sin(theta)*v;
							
							myBalls[n].moveCoord(triX, triY);
						}
	
				}
				
				if (BotWall.hitTestObject(myBalls[n]))
				{
					trace ("Ball hit bot wall");
					myBalls[n].Bouncer();
				}
				if (TopWall.hitTestObject(myBalls[n]))
				{
					trace ("Ball hit top wall");
					myBalls[n].Bouncer();
				}
			}
			
			
		}
	
	}
	
}
