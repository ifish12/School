namespace PizzaProject
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.picPizza = new System.Windows.Forms.PictureBox();
            this.picSoda = new System.Windows.Forms.PictureBox();
            this.chkPizza = new System.Windows.Forms.CheckBox();
            this.chkSoda = new System.Windows.Forms.CheckBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.chkLarP = new System.Windows.Forms.CheckBox();
            this.chkMedP = new System.Windows.Forms.CheckBox();
            this.chkSmallP = new System.Windows.Forms.CheckBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.rdbLargeS = new System.Windows.Forms.RadioButton();
            this.rdbSmallS = new System.Windows.Forms.RadioButton();
            this.rdbNull2 = new System.Windows.Forms.RadioButton();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.chkBacon = new System.Windows.Forms.CheckBox();
            this.chkPepperoni = new System.Windows.Forms.CheckBox();
            this.chkMushrooms = new System.Windows.Forms.CheckBox();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.rdbLemonLime = new System.Windows.Forms.RadioButton();
            this.rdbNull1 = new System.Windows.Forms.RadioButton();
            this.rdbGrape = new System.Windows.Forms.RadioButton();
            this.rdbOrange = new System.Windows.Forms.RadioButton();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.rdbZoneX = new System.Windows.Forms.RadioButton();
            this.rdbZone2 = new System.Windows.Forms.RadioButton();
            this.rdbZone1 = new System.Windows.Forms.RadioButton();
            this.rdbNull3 = new System.Windows.Forms.RadioButton();
            this.lblPizza = new System.Windows.Forms.Label();
            this.lblSoda = new System.Windows.Forms.Label();
            this.lblTopp = new System.Windows.Forms.Label();
            this.lblDeliv = new System.Windows.Forms.Label();
            this.lblTax = new System.Windows.Forms.Label();
            this.lblTot = new System.Windows.Forms.Label();
            this.lblPizzaTot = new System.Windows.Forms.Label();
            this.lblSodaTot = new System.Windows.Forms.Label();
            this.lblToppTot = new System.Windows.Forms.Label();
            this.lblDelivTot = new System.Windows.Forms.Label();
            this.lblTaxTot = new System.Windows.Forms.Label();
            this.lblTotTot = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.Clear = new System.Windows.Forms.Button();
            this.btnCalc = new System.Windows.Forms.Button();
            this.btnName = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.picPizza)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picSoda)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.SuspendLayout();
            // 
            // picPizza
            // 
            this.picPizza.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.picPizza.Image = ((System.Drawing.Image)(resources.GetObject("picPizza.Image")));
            this.picPizza.Location = new System.Drawing.Point(19, 313);
            this.picPizza.Name = "picPizza";
            this.picPizza.Size = new System.Drawing.Size(162, 115);
            this.picPizza.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picPizza.TabIndex = 0;
            this.picPizza.TabStop = false;
            this.picPizza.Visible = false;
            // 
            // picSoda
            // 
            this.picSoda.Image = ((System.Drawing.Image)(resources.GetObject("picSoda.Image")));
            this.picSoda.Location = new System.Drawing.Point(208, 313);
            this.picSoda.Name = "picSoda";
            this.picSoda.Size = new System.Drawing.Size(162, 115);
            this.picSoda.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picSoda.TabIndex = 1;
            this.picSoda.TabStop = false;
            this.picSoda.Visible = false;
            // 
            // chkPizza
            // 
            this.chkPizza.AutoSize = true;
            this.chkPizza.Location = new System.Drawing.Point(12, 12);
            this.chkPizza.Name = "chkPizza";
            this.chkPizza.Size = new System.Drawing.Size(51, 17);
            this.chkPizza.TabIndex = 2;
            this.chkPizza.Text = "Pizza";
            this.chkPizza.UseVisualStyleBackColor = true;
            this.chkPizza.CheckedChanged += new System.EventHandler(this.chkPizza_CheckedChanged);
            // 
            // chkSoda
            // 
            this.chkSoda.AutoSize = true;
            this.chkSoda.Location = new System.Drawing.Point(208, 12);
            this.chkSoda.Name = "chkSoda";
            this.chkSoda.Size = new System.Drawing.Size(51, 17);
            this.chkSoda.TabIndex = 3;
            this.chkSoda.Text = "Soda";
            this.chkSoda.UseVisualStyleBackColor = true;
            this.chkSoda.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.chkLarP);
            this.groupBox1.Controls.Add(this.chkMedP);
            this.groupBox1.Controls.Add(this.chkSmallP);
            this.groupBox1.Location = new System.Drawing.Point(12, 66);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(106, 104);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Size";
            // 
            // chkLarP
            // 
            this.chkLarP.AutoSize = true;
            this.chkLarP.Location = new System.Drawing.Point(7, 68);
            this.chkLarP.Name = "chkLarP";
            this.chkLarP.Size = new System.Drawing.Size(89, 17);
            this.chkLarP.TabIndex = 2;
            this.chkLarP.Text = "Large $14.00";
            this.chkLarP.UseVisualStyleBackColor = true;
            this.chkLarP.CheckedChanged += new System.EventHandler(this.chkLarP_CheckedChanged);
            // 
            // chkMedP
            // 
            this.chkMedP.AutoSize = true;
            this.chkMedP.Location = new System.Drawing.Point(7, 44);
            this.chkMedP.Name = "chkMedP";
            this.chkMedP.Size = new System.Drawing.Size(99, 17);
            this.chkMedP.TabIndex = 1;
            this.chkMedP.Text = "Medium $12.00";
            this.chkMedP.UseVisualStyleBackColor = true;
            this.chkMedP.CheckedChanged += new System.EventHandler(this.chkMedP_CheckedChanged);
            // 
            // chkSmallP
            // 
            this.chkSmallP.AutoSize = true;
            this.chkSmallP.Location = new System.Drawing.Point(7, 20);
            this.chkSmallP.Name = "chkSmallP";
            this.chkSmallP.Size = new System.Drawing.Size(87, 17);
            this.chkSmallP.TabIndex = 0;
            this.chkSmallP.Text = "Small $10.00";
            this.chkSmallP.UseVisualStyleBackColor = true;
            this.chkSmallP.CheckedChanged += new System.EventHandler(this.chkSmallP_CheckedChanged_1);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.rdbLargeS);
            this.groupBox2.Controls.Add(this.rdbSmallS);
            this.groupBox2.Controls.Add(this.rdbNull2);
            this.groupBox2.Location = new System.Drawing.Point(208, 66);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(109, 104);
            this.groupBox2.TabIndex = 5;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Size";
            // 
            // rdbLargeS
            // 
            this.rdbLargeS.AutoSize = true;
            this.rdbLargeS.Location = new System.Drawing.Point(7, 58);
            this.rdbLargeS.Name = "rdbLargeS";
            this.rdbLargeS.Size = new System.Drawing.Size(88, 17);
            this.rdbLargeS.TabIndex = 1;
            this.rdbLargeS.TabStop = true;
            this.rdbLargeS.Text = "Large $30.00";
            this.rdbLargeS.UseVisualStyleBackColor = true;
            this.rdbLargeS.CheckedChanged += new System.EventHandler(this.rdbLargeS_CheckedChanged);
            // 
            // rdbSmallS
            // 
            this.rdbSmallS.AutoSize = true;
            this.rdbSmallS.Location = new System.Drawing.Point(6, 20);
            this.rdbSmallS.Name = "rdbSmallS";
            this.rdbSmallS.Size = new System.Drawing.Size(86, 17);
            this.rdbSmallS.TabIndex = 0;
            this.rdbSmallS.TabStop = true;
            this.rdbSmallS.Text = "Small $10.00";
            this.rdbSmallS.UseVisualStyleBackColor = true;
            this.rdbSmallS.CheckedChanged += new System.EventHandler(this.rdbSmallS_CheckedChanged);
            // 
            // rdbNull2
            // 
            this.rdbNull2.AutoSize = true;
            this.rdbNull2.Checked = true;
            this.rdbNull2.Location = new System.Drawing.Point(46, 85);
            this.rdbNull2.Name = "rdbNull2";
            this.rdbNull2.Size = new System.Drawing.Size(14, 13);
            this.rdbNull2.TabIndex = 0;
            this.rdbNull2.TabStop = true;
            this.rdbNull2.UseVisualStyleBackColor = true;
            this.rdbNull2.Visible = false;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.chkBacon);
            this.groupBox3.Controls.Add(this.chkPepperoni);
            this.groupBox3.Controls.Add(this.chkMushrooms);
            this.groupBox3.Location = new System.Drawing.Point(12, 183);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(136, 105);
            this.groupBox3.TabIndex = 6;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Toppings";
            // 
            // chkBacon
            // 
            this.chkBacon.AutoSize = true;
            this.chkBacon.Location = new System.Drawing.Point(7, 67);
            this.chkBacon.Name = "chkBacon";
            this.chkBacon.Size = new System.Drawing.Size(87, 17);
            this.chkBacon.TabIndex = 8;
            this.chkBacon.Text = "Bacon $1.50";
            this.chkBacon.UseVisualStyleBackColor = true;
            this.chkBacon.CheckedChanged += new System.EventHandler(this.chkBacon_CheckedChanged);
            // 
            // chkPepperoni
            // 
            this.chkPepperoni.AutoSize = true;
            this.chkPepperoni.Location = new System.Drawing.Point(6, 43);
            this.chkPepperoni.Name = "chkPepperoni";
            this.chkPepperoni.Size = new System.Drawing.Size(104, 17);
            this.chkPepperoni.TabIndex = 7;
            this.chkPepperoni.Text = "Pepperoni $1.00";
            this.chkPepperoni.UseVisualStyleBackColor = true;
            this.chkPepperoni.CheckedChanged += new System.EventHandler(this.chkPepperoni_CheckedChanged);
            // 
            // chkMushrooms
            // 
            this.chkMushrooms.AutoSize = true;
            this.chkMushrooms.Location = new System.Drawing.Point(7, 19);
            this.chkMushrooms.Name = "chkMushrooms";
            this.chkMushrooms.Size = new System.Drawing.Size(110, 17);
            this.chkMushrooms.TabIndex = 0;
            this.chkMushrooms.Text = "Mushrooms $1.00";
            this.chkMushrooms.UseVisualStyleBackColor = true;
            this.chkMushrooms.CheckedChanged += new System.EventHandler(this.chkMushrooms_CheckedChanged);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.rdbLemonLime);
            this.groupBox4.Controls.Add(this.rdbNull1);
            this.groupBox4.Controls.Add(this.rdbGrape);
            this.groupBox4.Controls.Add(this.rdbOrange);
            this.groupBox4.Location = new System.Drawing.Point(208, 183);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(128, 105);
            this.groupBox4.TabIndex = 7;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Type";
            // 
            // rdbLemonLime
            // 
            this.rdbLemonLime.AutoSize = true;
            this.rdbLemonLime.Location = new System.Drawing.Point(6, 66);
            this.rdbLemonLime.Name = "rdbLemonLime";
            this.rdbLemonLime.Size = new System.Drawing.Size(112, 17);
            this.rdbLemonLime.TabIndex = 9;
            this.rdbLemonLime.TabStop = true;
            this.rdbLemonLime.Text = "Lemon Lime $1.50";
            this.rdbLemonLime.UseVisualStyleBackColor = true;
            this.rdbLemonLime.CheckedChanged += new System.EventHandler(this.rdbLemonLime_CheckedChanged);
            // 
            // rdbNull1
            // 
            this.rdbNull1.AutoSize = true;
            this.rdbNull1.Checked = true;
            this.rdbNull1.Location = new System.Drawing.Point(104, 86);
            this.rdbNull1.Name = "rdbNull1";
            this.rdbNull1.Size = new System.Drawing.Size(14, 13);
            this.rdbNull1.TabIndex = 0;
            this.rdbNull1.TabStop = true;
            this.rdbNull1.UseVisualStyleBackColor = true;
            this.rdbNull1.Visible = false;
            // 
            // rdbGrape
            // 
            this.rdbGrape.AutoSize = true;
            this.rdbGrape.Location = new System.Drawing.Point(6, 42);
            this.rdbGrape.Name = "rdbGrape";
            this.rdbGrape.Size = new System.Drawing.Size(84, 17);
            this.rdbGrape.TabIndex = 8;
            this.rdbGrape.TabStop = true;
            this.rdbGrape.Text = "Grape $1.00";
            this.rdbGrape.UseVisualStyleBackColor = true;
            this.rdbGrape.CheckedChanged += new System.EventHandler(this.rdbGrape_CheckedChanged);
            // 
            // rdbOrange
            // 
            this.rdbOrange.AutoSize = true;
            this.rdbOrange.Location = new System.Drawing.Point(7, 20);
            this.rdbOrange.Name = "rdbOrange";
            this.rdbOrange.Size = new System.Drawing.Size(90, 17);
            this.rdbOrange.TabIndex = 0;
            this.rdbOrange.TabStop = true;
            this.rdbOrange.Text = "Orange $1.00";
            this.rdbOrange.UseVisualStyleBackColor = true;
            this.rdbOrange.CheckedChanged += new System.EventHandler(this.rdbOrange_CheckedChanged);
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.rdbZoneX);
            this.groupBox5.Controls.Add(this.rdbZone2);
            this.groupBox5.Controls.Add(this.rdbZone1);
            this.groupBox5.Controls.Add(this.rdbNull3);
            this.groupBox5.Location = new System.Drawing.Point(426, 66);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(200, 100);
            this.groupBox5.TabIndex = 8;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "Delivery";
            // 
            // rdbZoneX
            // 
            this.rdbZoneX.AutoSize = true;
            this.rdbZoneX.Location = new System.Drawing.Point(7, 66);
            this.rdbZoneX.Name = "rdbZoneX";
            this.rdbZoneX.Size = new System.Drawing.Size(52, 17);
            this.rdbZoneX.TabIndex = 3;
            this.rdbZoneX.Text = "Eat in";
            this.rdbZoneX.UseVisualStyleBackColor = true;
            this.rdbZoneX.CheckedChanged += new System.EventHandler(this.rdbZoneX_CheckedChanged);
            // 
            // rdbZone2
            // 
            this.rdbZone2.AutoSize = true;
            this.rdbZone2.Location = new System.Drawing.Point(7, 43);
            this.rdbZone2.Name = "rdbZone2";
            this.rdbZone2.Size = new System.Drawing.Size(95, 17);
            this.rdbZone2.TabIndex = 2;
            this.rdbZone2.Text = "Zone 2 $40.00";
            this.rdbZone2.UseVisualStyleBackColor = true;
            this.rdbZone2.CheckedChanged += new System.EventHandler(this.rdbZone2_CheckedChanged);
            // 
            // rdbZone1
            // 
            this.rdbZone1.AutoSize = true;
            this.rdbZone1.Location = new System.Drawing.Point(7, 20);
            this.rdbZone1.Name = "rdbZone1";
            this.rdbZone1.Size = new System.Drawing.Size(95, 17);
            this.rdbZone1.TabIndex = 1;
            this.rdbZone1.Text = "Zone 1 $30.00";
            this.rdbZone1.UseVisualStyleBackColor = true;
            this.rdbZone1.CheckedChanged += new System.EventHandler(this.rdbZone1_CheckedChanged);
            // 
            // rdbNull3
            // 
            this.rdbNull3.AutoSize = true;
            this.rdbNull3.Checked = true;
            this.rdbNull3.Location = new System.Drawing.Point(180, 81);
            this.rdbNull3.Name = "rdbNull3";
            this.rdbNull3.Size = new System.Drawing.Size(14, 13);
            this.rdbNull3.TabIndex = 0;
            this.rdbNull3.TabStop = true;
            this.rdbNull3.UseVisualStyleBackColor = true;
            this.rdbNull3.Visible = false;
            // 
            // lblPizza
            // 
            this.lblPizza.AutoSize = true;
            this.lblPizza.Location = new System.Drawing.Point(407, 183);
            this.lblPizza.Name = "lblPizza";
            this.lblPizza.Size = new System.Drawing.Size(32, 13);
            this.lblPizza.TabIndex = 9;
            this.lblPizza.Text = "Pizza";
            // 
            // lblSoda
            // 
            this.lblSoda.AutoSize = true;
            this.lblSoda.Location = new System.Drawing.Point(407, 221);
            this.lblSoda.Name = "lblSoda";
            this.lblSoda.Size = new System.Drawing.Size(32, 13);
            this.lblSoda.TabIndex = 10;
            this.lblSoda.Text = "Soda";
            // 
            // lblTopp
            // 
            this.lblTopp.AutoSize = true;
            this.lblTopp.Location = new System.Drawing.Point(407, 259);
            this.lblTopp.Name = "lblTopp";
            this.lblTopp.Size = new System.Drawing.Size(51, 13);
            this.lblTopp.TabIndex = 11;
            this.lblTopp.Text = "Toppings";
            // 
            // lblDeliv
            // 
            this.lblDeliv.AutoSize = true;
            this.lblDeliv.Location = new System.Drawing.Point(407, 297);
            this.lblDeliv.Name = "lblDeliv";
            this.lblDeliv.Size = new System.Drawing.Size(45, 13);
            this.lblDeliv.TabIndex = 12;
            this.lblDeliv.Text = "Delivery";
            // 
            // lblTax
            // 
            this.lblTax.AutoSize = true;
            this.lblTax.Location = new System.Drawing.Point(407, 335);
            this.lblTax.Name = "lblTax";
            this.lblTax.Size = new System.Drawing.Size(36, 13);
            this.lblTax.TabIndex = 13;
            this.lblTax.Text = "Taxes";
            // 
            // lblTot
            // 
            this.lblTot.AutoSize = true;
            this.lblTot.Location = new System.Drawing.Point(407, 373);
            this.lblTot.Name = "lblTot";
            this.lblTot.Size = new System.Drawing.Size(31, 13);
            this.lblTot.TabIndex = 14;
            this.lblTot.Text = "Total";
            // 
            // lblPizzaTot
            // 
            this.lblPizzaTot.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblPizzaTot.Location = new System.Drawing.Point(510, 182);
            this.lblPizzaTot.Name = "lblPizzaTot";
            this.lblPizzaTot.Size = new System.Drawing.Size(100, 23);
            this.lblPizzaTot.TabIndex = 15;
            this.lblPizzaTot.Click += new System.EventHandler(this.lblPizzaTot_Click);
            // 
            // lblSodaTot
            // 
            this.lblSodaTot.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblSodaTot.Location = new System.Drawing.Point(510, 221);
            this.lblSodaTot.Name = "lblSodaTot";
            this.lblSodaTot.Size = new System.Drawing.Size(100, 23);
            this.lblSodaTot.TabIndex = 16;
            this.lblSodaTot.Click += new System.EventHandler(this.lblSodaTot_Click);
            // 
            // lblToppTot
            // 
            this.lblToppTot.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblToppTot.Location = new System.Drawing.Point(510, 250);
            this.lblToppTot.Name = "lblToppTot";
            this.lblToppTot.Size = new System.Drawing.Size(100, 23);
            this.lblToppTot.TabIndex = 17;
            this.lblToppTot.Click += new System.EventHandler(this.lblToppTot_Click);
            // 
            // lblDelivTot
            // 
            this.lblDelivTot.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblDelivTot.Location = new System.Drawing.Point(510, 287);
            this.lblDelivTot.Name = "lblDelivTot";
            this.lblDelivTot.Size = new System.Drawing.Size(100, 23);
            this.lblDelivTot.TabIndex = 18;
            this.lblDelivTot.Click += new System.EventHandler(this.lblDelivTot_Click);
            // 
            // lblTaxTot
            // 
            this.lblTaxTot.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblTaxTot.Location = new System.Drawing.Point(510, 325);
            this.lblTaxTot.Name = "lblTaxTot";
            this.lblTaxTot.Size = new System.Drawing.Size(100, 23);
            this.lblTaxTot.TabIndex = 19;
            this.lblTaxTot.Click += new System.EventHandler(this.lblTaxTot_Click);
            // 
            // lblTotTot
            // 
            this.lblTotTot.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblTotTot.Location = new System.Drawing.Point(510, 363);
            this.lblTotTot.Name = "lblTotTot";
            this.lblTotTot.Size = new System.Drawing.Size(100, 23);
            this.lblTotTot.TabIndex = 20;
            this.lblTotTot.Click += new System.EventHandler(this.lblTotTot_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(380, 400);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(78, 29);
            this.btnExit.TabIndex = 21;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // Clear
            // 
            this.Clear.Location = new System.Drawing.Point(464, 400);
            this.Clear.Name = "Clear";
            this.Clear.Size = new System.Drawing.Size(78, 28);
            this.Clear.TabIndex = 22;
            this.Clear.Text = "Clear";
            this.Clear.UseVisualStyleBackColor = true;
            this.Clear.Click += new System.EventHandler(this.Clear_Click);
            // 
            // btnCalc
            // 
            this.btnCalc.Location = new System.Drawing.Point(548, 401);
            this.btnCalc.Name = "btnCalc";
            this.btnCalc.Size = new System.Drawing.Size(78, 28);
            this.btnCalc.TabIndex = 23;
            this.btnCalc.Text = "Calculate";
            this.btnCalc.UseVisualStyleBackColor = true;
            this.btnCalc.Click += new System.EventHandler(this.btnCalc_Click);
            // 
            // btnName
            // 
            this.btnName.Location = new System.Drawing.Point(548, 12);
            this.btnName.Name = "btnName";
            this.btnName.Size = new System.Drawing.Size(78, 29);
            this.btnName.TabIndex = 24;
            this.btnName.Text = "Name";
            this.btnName.UseVisualStyleBackColor = true;
            this.btnName.Click += new System.EventHandler(this.btnName_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(638, 461);
            this.Controls.Add(this.btnName);
            this.Controls.Add(this.btnCalc);
            this.Controls.Add(this.Clear);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.lblTotTot);
            this.Controls.Add(this.lblTaxTot);
            this.Controls.Add(this.lblDelivTot);
            this.Controls.Add(this.lblToppTot);
            this.Controls.Add(this.lblSodaTot);
            this.Controls.Add(this.lblPizzaTot);
            this.Controls.Add(this.lblTot);
            this.Controls.Add(this.lblTax);
            this.Controls.Add(this.lblDeliv);
            this.Controls.Add(this.lblTopp);
            this.Controls.Add(this.lblSoda);
            this.Controls.Add(this.lblPizza);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.chkSoda);
            this.Controls.Add(this.chkPizza);
            this.Controls.Add(this.picSoda);
            this.Controls.Add(this.picPizza);
            this.Name = "Form1";
            this.Text = "Menu";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.picPizza)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picSoda)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox picPizza;
        private System.Windows.Forms.PictureBox picSoda;
        private System.Windows.Forms.CheckBox chkPizza;
        private System.Windows.Forms.CheckBox chkSoda;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.CheckBox chkLarP;
        private System.Windows.Forms.CheckBox chkMedP;
        private System.Windows.Forms.CheckBox chkSmallP;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.RadioButton rdbLargeS;
        private System.Windows.Forms.RadioButton rdbSmallS;
        private System.Windows.Forms.RadioButton rdbNull2;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.CheckBox chkBacon;
        private System.Windows.Forms.CheckBox chkPepperoni;
        private System.Windows.Forms.CheckBox chkMushrooms;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.RadioButton rdbLemonLime;
        private System.Windows.Forms.RadioButton rdbGrape;
        private System.Windows.Forms.RadioButton rdbOrange;
        private System.Windows.Forms.RadioButton rdbNull1;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.RadioButton rdbZoneX;
        private System.Windows.Forms.RadioButton rdbZone2;
        private System.Windows.Forms.RadioButton rdbZone1;
        private System.Windows.Forms.RadioButton rdbNull3;
        private System.Windows.Forms.Label lblPizza;
        private System.Windows.Forms.Label lblSoda;
        private System.Windows.Forms.Label lblTopp;
        private System.Windows.Forms.Label lblDeliv;
        private System.Windows.Forms.Label lblTax;
        private System.Windows.Forms.Label lblTot;
        private System.Windows.Forms.Label lblPizzaTot;
        private System.Windows.Forms.Label lblSodaTot;
        private System.Windows.Forms.Label lblToppTot;
        private System.Windows.Forms.Label lblDelivTot;
        private System.Windows.Forms.Label lblTaxTot;
        private System.Windows.Forms.Label lblTotTot;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button Clear;
        private System.Windows.Forms.Button btnCalc;
        private System.Windows.Forms.Button btnName;
    }
}

