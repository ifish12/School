//
//  DrawingView.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class DrawingView: UIView {

    var touchesBeganLocation = CGPointZero
    var shapeType = 0
    var shapes = [Shape]()
    var inprog : Shape?;
    var myParent : ViewController!
    
    var CurrentStyle = Options()
    var context:CGContext?
    
    var xOffSet:Double = 0;
    var yOffSet:Double = 0;
    
    
    var LineColor:[CGFloat] = [1.0, 1.0, 0.0, 1.0]
    
    var movingShape = false;
    //var pinchingShape = false;
    
    
 
    override func drawRect(rect: CGRect) {

        context = UIGraphicsGetCurrentContext()
    
        
        for i in 0..<shapes.count {
            
            shapes[i].draw(context!)
            
        }
        if let temp = inprog {
            temp.draw(context!)
        }

    }
    
    
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
       
        CurrentStyle = myParent.options
        let touch = touches.first! as UITouch
        touchesBeganLocation = touch.locationInView(self)
        
        var s:Shape?;
        if(shapes.count != 0){
            s = touchedShape()
        }
        if(s != nil){
            movingShape = true;
            inprog = s;
            //CurrentStyle = (inprog?.Style)!;//Need to save move shapes style
            
            CurrentStyle = Options(LineWidth:(inprog?.Style.LineWidth)!, LineColor:(inprog?.Style.LineColor)!, Filled:(inprog?.Style.Filled)!, FillColor:(inprog?.Style.FillColor)!);
            
            inprog?.Style = Options();
            if(inprog?.Width < 0 && inprog?.Height < 0){ // both w h negative
                xOffSet =  (inprog!.X - Double(touchesBeganLocation.x))*(-1);
                yOffSet =  (inprog!.Y - Double(touchesBeganLocation.y))*(-1);
                print("if 3");
                
            }
            else if(inprog?.Width > 0 && inprog?.Height > 0){ // both w h positive
                xOffSet =  Double(touchesBeganLocation.x) - inprog!.X;
                yOffSet =  Double(touchesBeganLocation.y) - inprog!.Y;
            }
                
            else if(inprog?.Width < 0 && inprog?.Height > 0){    // w neg h pos
                xOffSet =  (inprog!.X - Double(touchesBeganLocation.x))*(-1);
                yOffSet =  Double(touchesBeganLocation.y) - inprog!.Y;
                print("if 2");
                
            }
            else if(inprog?.Width > 0 && inprog?.Height < 0){ // w pos h neg
                xOffSet =  Double(touchesBeganLocation.x) - inprog!.X;
                yOffSet =  (inprog!.Y - Double(touchesBeganLocation.y))*(-1);
                print("if 4");
                
            }

            print("touches x: ", touchesBeganLocation.x)
            print("touches y: ", touchesBeganLocation.y)
            print("Touched object");
        }
    }
    
    
    override func touchesMoved(touches: Set<UITouch>, withEvent event: UIEvent?) {
        
        
        
        let touch = touches.first! as UITouch
        let currentTouchLocation = touch.locationInView(self)
        
        if(movingShape == false){
            var height:Double
            var width:Double
            if(touchesBeganLocation.y < currentTouchLocation.y){
                height = Double(currentTouchLocation.y) - Double(touchesBeganLocation.y);
            }
            else{
                height = (Double(touchesBeganLocation.y) - Double(currentTouchLocation.y))*(-1);
            }
            if(touchesBeganLocation.x < currentTouchLocation.x){
                width = (Double(touchesBeganLocation.x) - Double(currentTouchLocation.x))*(-1);
            }
            else{
                width = Double(currentTouchLocation.x) - Double(touchesBeganLocation.x);
            }
            
            if shapeType == 0 {
                inprog = Rect(X: Double(touchesBeganLocation.x), Y: Double(touchesBeganLocation.y), Style: CurrentStyle, Height: height, Width: width)
                
            }
            else if(shapeType == 1){
                inprog = Oval(X: Double(touchesBeganLocation.x), Y: Double(touchesBeganLocation.y), Style: CurrentStyle, Height: height, Width: width)
            }
            else{
                inprog = Line(X: Double(touchesBeganLocation.x), Y: Double(touchesBeganLocation.y), Style: CurrentStyle, Height: height, Width: width)
            }
            
            self.setNeedsDisplay()
            
            myParent?.EraseBtn.enabled = true
            myParent?.SaveBtn.enabled = true
        }
            
        else{
            
            if let line = inprog as? Line {
                line.X = Double(currentTouchLocation.x) - xOffSet;
                line.Y = Double(currentTouchLocation.y) - yOffSet;
                line.X2 = line.X  + line.Width;
                line.Y2 = line.Y + line.Height;

                
                

            } else  {
                inprog?.X = Double(currentTouchLocation.x) - xOffSet;
                inprog?.Y = Double(currentTouchLocation.y) - yOffSet;
            }
            
            self.setNeedsDisplay()
        
        
            myParent?.EraseBtn.enabled = true
            myParent?.SaveBtn.enabled = true
        }
        
    }
    
    
    


    override func touchesEnded(touches: Set<UITouch>, withEvent event: UIEvent?) {
        

        
        if let temp = inprog {
        
            temp.Style = CurrentStyle;
            shapes.append(temp)
            movingShape = false;
        
        self.setNeedsDisplay()
        inprog = nil;
        myParent?.EraseBtn.enabled = true
        myParent?.SaveBtn.enabled = true
        }
    }
    
    
    func touchedShape() -> Shape?{
        var found:Shape?
        
        for var i = shapes.count - 1; i >= 0; i-- {
            if(shapes[i].contains(touchesBeganLocation)){
                
          
                found = shapes[i];
                shapes.removeAtIndex(i);
                
                print("print saved object :" ,found);
                return found;
            }
        }
        
        return found;

    }
    




}
