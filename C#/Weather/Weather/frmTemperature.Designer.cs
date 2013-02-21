namespace Weather
{
    partial class frmTemperature
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
            this.lblCel = new System.Windows.Forms.Label();
            this.lblFah = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.hsTemp = new System.Windows.Forms.HScrollBar();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lblInch = new System.Windows.Forms.Label();
            this.lblCM = new System.Windows.Forms.Label();
            this.trbMeasure = new System.Windows.Forms.TrackBar();
            ((System.ComponentModel.ISupportInitialize)(this.trbMeasure)).BeginInit();
            this.SuspendLayout();
            // 
            // lblCel
            // 
            this.lblCel.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblCel.Location = new System.Drawing.Point(137, 47);
            this.lblCel.Name = "lblCel";
            this.lblCel.Size = new System.Drawing.Size(128, 60);
            this.lblCel.TabIndex = 0;
            this.lblCel.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // lblFah
            // 
            this.lblFah.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblFah.Location = new System.Drawing.Point(137, 243);
            this.lblFah.Name = "lblFah";
            this.lblFah.Size = new System.Drawing.Size(128, 64);
            this.lblFah.TabIndex = 1;
            this.lblFah.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(182, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Celcius";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(182, 190);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(57, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Fahrenheit";
            // 
            // hsTemp
            // 
            this.hsTemp.LargeChange = 5;
            this.hsTemp.Location = new System.Drawing.Point(9, 138);
            this.hsTemp.Minimum = -40;
            this.hsTemp.Name = "hsTemp";
            this.hsTemp.Size = new System.Drawing.Size(387, 29);
            this.hsTemp.TabIndex = 4;
            this.hsTemp.Scroll += new System.Windows.Forms.ScrollEventHandler(this.hsTemp_Scroll);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(646, 25);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(39, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Inches";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(649, 190);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(62, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Centimeters";
            // 
            // lblInch
            // 
            this.lblInch.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblInch.Location = new System.Drawing.Point(632, 47);
            this.lblInch.Name = "lblInch";
            this.lblInch.Size = new System.Drawing.Size(126, 60);
            this.lblInch.TabIndex = 7;
            // 
            // lblCM
            // 
            this.lblCM.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblCM.Location = new System.Drawing.Point(632, 243);
            this.lblCM.Name = "lblCM";
            this.lblCM.Size = new System.Drawing.Size(126, 64);
            this.lblCM.TabIndex = 8;
            // 
            // trbMeasure
            // 
            this.trbMeasure.Location = new System.Drawing.Point(580, 121);
            this.trbMeasure.Maximum = 100;
            this.trbMeasure.Name = "trbMeasure";
            this.trbMeasure.Size = new System.Drawing.Size(241, 45);
            this.trbMeasure.TabIndex = 9;
            this.trbMeasure.TickFrequency = 10;
            this.trbMeasure.TickStyle = System.Windows.Forms.TickStyle.Both;
            this.trbMeasure.Scroll += new System.EventHandler(this.trbMeasure_Scroll);
            // 
            // frmTemperature
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(833, 336);
            this.Controls.Add(this.trbMeasure);
            this.Controls.Add(this.lblCM);
            this.Controls.Add(this.lblInch);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.hsTemp);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblFah);
            this.Controls.Add(this.lblCel);
            this.Name = "frmTemperature";
            this.Text = "Temperature";
            ((System.ComponentModel.ISupportInitialize)(this.trbMeasure)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblCel;
        private System.Windows.Forms.Label lblFah;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.HScrollBar hsTemp;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lblInch;
        private System.Windows.Forms.Label lblCM;
        private System.Windows.Forms.TrackBar trbMeasure;
    }
}