//
//  ViewController.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class ViewController: UIViewController, OptionsSavable {

 
    @IBOutlet weak var SelectShapeSegmentedControl: UISegmentedControl!
    @IBOutlet weak var LoadBtn: UIButton!
    @IBOutlet weak var EraseBtn: UIButton!
    @IBAction func handlePinch(recognizer: UIPinchGestureRecognizer) {
        if(drawingView.inprog != nil){
            if let _ = recognizer.view {
                let scale = recognizer.scale
                
                //print("scale", scale);
                
                recognizer.scale = 1
                print("scale", scale);
                
                print("inprog", drawingView.inprog);
                
                let oldwidth = drawingView.inprog!.Width;
                let oldheight = drawingView.inprog!.Height;
                
                drawingView.inprog!.Height = drawingView.inprog!.Height * Double(scale);
                drawingView.inprog!.Width = drawingView.inprog!.Width * Double(scale);
                
                drawingView.inprog!.X = drawingView.inprog!.X + (oldwidth - drawingView.inprog!.Width)/2
                drawingView.inprog!.Y = drawingView.inprog!.Y + (oldheight - drawingView.inprog!.Height)/2
                
                if let line = drawingView.inprog as? Line {
                    line.X2 = line.X + line.Width;
                    line.Y2 = line.Y + line.Height;
        
                }
                drawingView.setNeedsDisplay();
            }
        
        
        if recognizer.state == UIGestureRecognizerState.Ended {
            drawingView.inprog!.Style = drawingView.CurrentStyle;
            drawingView.shapes.append(drawingView.inprog!)
            drawingView.movingShape = false;
            
            drawingView.setNeedsDisplay()
            drawingView.inprog = nil;
            print("Xpooo");
        }
        }
        
    }
    @IBOutlet weak var SaveBtn: UIButton!
    var options = Options()

    
    
    func saveOptions(theOptions:Options){
        self.options = theOptions
        print(self.options.FillColor)
    }
    
    @IBAction func changeShape(sender: UISegmentedControl) {
        drawingView.shapeType = sender.selectedSegmentIndex
    }

    @IBAction func Erase_BarBtn_Click(sender: AnyObject) {
        drawingView.shapes.removeAll();
        drawingView.setNeedsDisplay();
        SaveBtn.enabled = false
        EraseBtn.enabled = false
        drawingView.movingShape = false;
    }
    
    
    @IBAction func Save_BarBtn_Click(sender: AnyObject) {
        let data  = NSKeyedArchiver.archivedDataWithRootObject(drawingView.shapes)
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setObject(data, forKey:"ShapesArray" )
        LoadBtn.enabled = true;
        

    }
    @IBAction func Load_BarBtn_Click(sender: AnyObject) {
        
        if let shapesData = NSUserDefaults.standardUserDefaults().objectForKey("ShapesArray") as? NSData {
            let shapesDecoded = NSKeyedUnarchiver.unarchiveObjectWithData(shapesData)
            drawingView.shapes = shapesDecoded as! [Shape]
        }
        if let styleData = NSUserDefaults.standardUserDefaults().objectForKey("Style") as? NSData {
            let styleDecoded = NSKeyedUnarchiver.unarchiveObjectWithData(styleData)
            drawingView.CurrentStyle = styleDecoded as! Options
        }
       
        drawingView.setNeedsDisplay();
        EraseBtn.enabled = true
        SaveBtn.enabled = false
    }
    @IBOutlet var drawingView: DrawingView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if let _ = NSUserDefaults.standardUserDefaults().objectForKey("ShapesArray") as? NSData {
            LoadBtn.enabled = true;
        }
        else{
            LoadBtn.enabled = false;
        }
    
        drawingView.myParent = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }


    @IBAction func Undo_BarBtn_Click(sender: UIBarButtonItem) {
        if(drawingView.shapes.isEmpty == false){
        drawingView.shapes.removeLast();
        drawingView.setNeedsDisplay();
        }
        if(drawingView.shapes.isEmpty == true)
        {
            SaveBtn.enabled = false
            EraseBtn.enabled = false
        }
    }
    
    override func viewDidAppear(animated: Bool){
        /*let appDomain: String = NSBundle.mainBundle().bundleIdentifier!
        NSUserDefaults.standardUserDefaults().removePersistentDomainForName(appDomain)*/

        
        if let styleData = NSUserDefaults.standardUserDefaults().objectForKey("Style") as? NSData {
            let styleDecoded = NSKeyedUnarchiver.unarchiveObjectWithData(styleData)
            options = styleDecoded as! Options
        }
    }
    
    
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject!) {
        if(segue.identifier == "options"){
           let vc = segue.destinationViewController as! OptionsUIViewController
            vc.myParent = self
            vc.displayshape = self.SelectShapeSegmentedControl.selectedSegmentIndex
            vc.previewOptions = self.options
        }
        
        
        
    }
}


