namespace Weather
{
    partial class frmRadioCheck
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmRadioCheck));
            this.chkCart = new System.Windows.Forms.CheckBox();
            this.chkChe = new System.Windows.Forms.CheckBox();
            this.chkBart = new System.Windows.Forms.CheckBox();
            this.picCart = new System.Windows.Forms.PictureBox();
            this.picChe = new System.Windows.Forms.PictureBox();
            this.picBart = new System.Windows.Forms.PictureBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radGreen = new System.Windows.Forms.RadioButton();
            this.radBlue = new System.Windows.Forms.RadioButton();
            this.radRed = new System.Windows.Forms.RadioButton();
            this.radDummy = new System.Windows.Forms.RadioButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnClr = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.picCart)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picChe)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picBart)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // chkCart
            // 
            this.chkCart.AutoSize = true;
            this.chkCart.Location = new System.Drawing.Point(56, 53);
            this.chkCart.Name = "chkCart";
            this.chkCart.Size = new System.Drawing.Size(65, 17);
            this.chkCart.TabIndex = 0;
            this.chkCart.Text = "Cartman";
            this.chkCart.UseVisualStyleBackColor = true;
            this.chkCart.CheckedChanged += new System.EventHandler(this.chkCart_CheckedChanged);
            // 
            // chkChe
            // 
            this.chkChe.AutoSize = true;
            this.chkChe.Location = new System.Drawing.Point(56, 152);
            this.chkChe.Name = "chkChe";
            this.chkChe.Size = new System.Drawing.Size(60, 17);
            this.chkChe.TabIndex = 1;
            this.chkChe.Text = "Cheeta";
            this.chkChe.UseVisualStyleBackColor = true;
            this.chkChe.CheckedChanged += new System.EventHandler(this.chkChe_CheckedChanged);
            // 
            // chkBart
            // 
            this.chkBart.AutoSize = true;
            this.chkBart.Location = new System.Drawing.Point(56, 247);
            this.chkBart.Name = "chkBart";
            this.chkBart.Size = new System.Drawing.Size(45, 17);
            this.chkBart.TabIndex = 2;
            this.chkBart.Text = "Bart";
            this.chkBart.UseVisualStyleBackColor = true;
            this.chkBart.CheckedChanged += new System.EventHandler(this.chkBart_CheckedChanged);
            // 
            // picCart
            // 
            this.picCart.Image = ((System.Drawing.Image)(resources.GetObject("picCart.Image")));
            this.picCart.Location = new System.Drawing.Point(160, 12);
            this.picCart.Name = "picCart";
            this.picCart.Size = new System.Drawing.Size(137, 118);
            this.picCart.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picCart.TabIndex = 3;
            this.picCart.TabStop = false;
            this.picCart.Visible = false;
            // 
            // picChe
            // 
            this.picChe.Image = ((System.Drawing.Image)(resources.GetObject("picChe.Image")));
            this.picChe.Location = new System.Drawing.Point(160, 136);
            this.picChe.Name = "picChe";
            this.picChe.Size = new System.Drawing.Size(137, 118);
            this.picChe.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picChe.TabIndex = 4;
            this.picChe.TabStop = false;
            this.picChe.Visible = false;
            // 
            // picBart
            // 
            this.picBart.Image = ((System.Drawing.Image)(resources.GetObject("picBart.Image")));
            this.picBart.Location = new System.Drawing.Point(160, 260);
            this.picBart.Name = "picBart";
            this.picBart.Size = new System.Drawing.Size(137, 118);
            this.picBart.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picBart.TabIndex = 5;
            this.picBart.TabStop = false;
            this.picBart.Visible = false;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radGreen);
            this.groupBox1.Controls.Add(this.radBlue);
            this.groupBox1.Controls.Add(this.radRed);
            this.groupBox1.Controls.Add(this.radDummy);
            this.groupBox1.Location = new System.Drawing.Point(487, 62);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(201, 157);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Radio Buttons";
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // radGreen
            // 
            this.radGreen.AutoSize = true;
            this.radGreen.Location = new System.Drawing.Point(6, 104);
            this.radGreen.Name = "radGreen";
            this.radGreen.Size = new System.Drawing.Size(54, 17);
            this.radGreen.TabIndex = 3;
            this.radGreen.TabStop = true;
            this.radGreen.Text = "Green";
            this.radGreen.UseVisualStyleBackColor = true;
            this.radGreen.CheckedChanged += new System.EventHandler(this.radGreen_CheckedChanged);
            // 
            // radBlue
            // 
            this.radBlue.AutoSize = true;
            this.radBlue.Location = new System.Drawing.Point(6, 64);
            this.radBlue.Name = "radBlue";
            this.radBlue.Size = new System.Drawing.Size(46, 17);
            this.radBlue.TabIndex = 2;
            this.radBlue.Text = "Blue";
            this.radBlue.UseVisualStyleBackColor = true;
            this.radBlue.CheckedChanged += new System.EventHandler(this.radBlue_CheckedChanged);
            // 
            // radRed
            // 
            this.radRed.AutoSize = true;
            this.radRed.Location = new System.Drawing.Point(6, 19);
            this.radRed.Name = "radRed";
            this.radRed.Size = new System.Drawing.Size(45, 17);
            this.radRed.TabIndex = 1;
            this.radRed.Text = "Red";
            this.radRed.UseVisualStyleBackColor = true;
            this.radRed.CheckedChanged += new System.EventHandler(this.radRed_CheckedChanged);
            // 
            // radDummy
            // 
            this.radDummy.AutoSize = true;
            this.radDummy.Checked = true;
            this.radDummy.Location = new System.Drawing.Point(181, 138);
            this.radDummy.Name = "radDummy";
            this.radDummy.Size = new System.Drawing.Size(14, 13);
            this.radDummy.TabIndex = 0;
            this.radDummy.TabStop = true;
            this.radDummy.UseVisualStyleBackColor = true;
            this.radDummy.Visible = false;
            this.radDummy.CheckedChanged += new System.EventHandler(this.radioButton1_CheckedChanged);
            // 
            // panel1
            // 
            this.panel1.Location = new System.Drawing.Point(487, 283);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(278, 161);
            this.panel1.TabIndex = 7;
            // 
            // btnClr
            // 
            this.btnClr.Location = new System.Drawing.Point(353, 346);
            this.btnClr.Name = "btnClr";
            this.btnClr.Size = new System.Drawing.Size(107, 108);
            this.btnClr.TabIndex = 8;
            this.btnClr.Text = "Clear";
            this.btnClr.UseVisualStyleBackColor = true;
            this.btnClr.Click += new System.EventHandler(this.btnClr_Click);
            // 
            // frmRadioCheck
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(801, 519);
            this.Controls.Add(this.btnClr);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.picBart);
            this.Controls.Add(this.picChe);
            this.Controls.Add(this.picCart);
            this.Controls.Add(this.chkBart);
            this.Controls.Add(this.chkChe);
            this.Controls.Add(this.chkCart);
            this.Name = "frmRadioCheck";
            this.Text = "frmRadioCheck";
            ((System.ComponentModel.ISupportInitialize)(this.picCart)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picChe)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picBart)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox chkCart;
        private System.Windows.Forms.CheckBox chkChe;
        private System.Windows.Forms.CheckBox chkBart;
        private System.Windows.Forms.PictureBox picCart;
        private System.Windows.Forms.PictureBox picChe;
        private System.Windows.Forms.PictureBox picBart;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radGreen;
        private System.Windows.Forms.RadioButton radBlue;
        private System.Windows.Forms.RadioButton radRed;
        private System.Windows.Forms.RadioButton radDummy;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btnClr;
    }
}