namespace First_Project
{
    partial class FrmConsume
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmConsume));
            this.lib1 = new System.Windows.Forms.Label();
            this.lib2 = new System.Windows.Forms.Label();
            this.lib3 = new System.Windows.Forms.Label();
            this.txtBoxDist = new System.Windows.Forms.TextBox();
            this.txtBoxLit = new System.Windows.Forms.TextBox();
            this.txtBoxPL = new System.Windows.Forms.TextBox();
            this.lib4 = new System.Windows.Forms.Label();
            this.lib5 = new System.Windows.Forms.Label();
            this.libOut1 = new System.Windows.Forms.Label();
            this.libOut2 = new System.Windows.Forms.Label();
            this.btnCalc = new System.Windows.Forms.Button();
            this.btnClr = new System.Windows.Forms.Button();
            this.btnExt = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lib1
            // 
            this.lib1.AutoSize = true;
            this.lib1.Location = new System.Drawing.Point(24, 36);
            this.lib1.Name = "lib1";
            this.lib1.Size = new System.Drawing.Size(49, 13);
            this.lib1.TabIndex = 0;
            this.lib1.Text = "Distance";
            // 
            // lib2
            // 
            this.lib2.AutoSize = true;
            this.lib2.Location = new System.Drawing.Point(25, 96);
            this.lib2.Name = "lib2";
            this.lib2.Size = new System.Drawing.Size(32, 13);
            this.lib2.TabIndex = 1;
            this.lib2.Text = "Liters";
            // 
            // lib3
            // 
            this.lib3.AutoSize = true;
            this.lib3.Location = new System.Drawing.Point(25, 156);
            this.lib3.Name = "lib3";
            this.lib3.Size = new System.Drawing.Size(31, 13);
            this.lib3.TabIndex = 2;
            this.lib3.Text = "Price";
            // 
            // txtBoxDist
            // 
            this.txtBoxDist.Location = new System.Drawing.Point(307, 29);
            this.txtBoxDist.Name = "txtBoxDist";
            this.txtBoxDist.Size = new System.Drawing.Size(100, 20);
            this.txtBoxDist.TabIndex = 3;
            this.txtBoxDist.TextChanged += new System.EventHandler(this.txtBoxDist_TextChanged);
            // 
            // txtBoxLit
            // 
            this.txtBoxLit.Location = new System.Drawing.Point(307, 88);
            this.txtBoxLit.Name = "txtBoxLit";
            this.txtBoxLit.Size = new System.Drawing.Size(100, 20);
            this.txtBoxLit.TabIndex = 4;
            this.txtBoxLit.TextChanged += new System.EventHandler(this.txtBoxLit_TextChanged);
            // 
            // txtBoxPL
            // 
            this.txtBoxPL.Location = new System.Drawing.Point(307, 155);
            this.txtBoxPL.Name = "txtBoxPL";
            this.txtBoxPL.Size = new System.Drawing.Size(100, 20);
            this.txtBoxPL.TabIndex = 5;
            this.txtBoxPL.TextChanged += new System.EventHandler(this.txtBoxPL_TextChanged);
            // 
            // lib4
            // 
            this.lib4.AutoSize = true;
            this.lib4.Location = new System.Drawing.Point(65, 227);
            this.lib4.Name = "lib4";
            this.lib4.Size = new System.Drawing.Size(27, 13);
            this.lib4.TabIndex = 6;
            this.lib4.Text = "KPL";
            // 
            // lib5
            // 
            this.lib5.AutoSize = true;
            this.lib5.Location = new System.Drawing.Point(409, 216);
            this.lib5.Name = "lib5";
            this.lib5.Size = new System.Drawing.Size(28, 13);
            this.lib5.TabIndex = 7;
            this.lib5.Text = "Cost";
            // 
            // libOut1
            // 
            this.libOut1.BackColor = System.Drawing.Color.White;
            this.libOut1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.libOut1.Location = new System.Drawing.Point(28, 262);
            this.libOut1.Name = "libOut1";
            this.libOut1.Size = new System.Drawing.Size(105, 32);
            this.libOut1.TabIndex = 8;
            // 
            // libOut2
            // 
            this.libOut2.BackColor = System.Drawing.Color.White;
            this.libOut2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.libOut2.Location = new System.Drawing.Point(386, 262);
            this.libOut2.Name = "libOut2";
            this.libOut2.Size = new System.Drawing.Size(89, 32);
            this.libOut2.TabIndex = 800;
            // 
            // btnCalc
            // 
            this.btnCalc.Location = new System.Drawing.Point(68, 367);
            this.btnCalc.Name = "btnCalc";
            this.btnCalc.Size = new System.Drawing.Size(75, 23);
            this.btnCalc.TabIndex = 801;
            this.btnCalc.Text = "Calculate";
            this.btnCalc.UseVisualStyleBackColor = true;
            this.btnCalc.Click += new System.EventHandler(this.btnCalc_Click);
            // 
            // btnClr
            // 
            this.btnClr.Location = new System.Drawing.Point(239, 367);
            this.btnClr.Name = "btnClr";
            this.btnClr.Size = new System.Drawing.Size(75, 23);
            this.btnClr.TabIndex = 802;
            this.btnClr.Text = "Clear";
            this.btnClr.UseVisualStyleBackColor = true;
            this.btnClr.Click += new System.EventHandler(this.btnClr_Click);
            // 
            // btnExt
            // 
            this.btnExt.Location = new System.Drawing.Point(402, 367);
            this.btnExt.Name = "btnExt";
            this.btnExt.Size = new System.Drawing.Size(75, 23);
            this.btnExt.TabIndex = 803;
            this.btnExt.Text = "Exit";
            this.btnExt.UseVisualStyleBackColor = true;
            this.btnExt.Click += new System.EventHandler(this.btnExt_Click);
            // 
            // FrmConsume
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.ClientSize = new System.Drawing.Size(555, 450);
            this.Controls.Add(this.btnExt);
            this.Controls.Add(this.btnClr);
            this.Controls.Add(this.btnCalc);
            this.Controls.Add(this.libOut2);
            this.Controls.Add(this.libOut1);
            this.Controls.Add(this.lib5);
            this.Controls.Add(this.lib4);
            this.Controls.Add(this.txtBoxPL);
            this.Controls.Add(this.txtBoxLit);
            this.Controls.Add(this.txtBoxDist);
            this.Controls.Add(this.lib3);
            this.Controls.Add(this.lib2);
            this.Controls.Add(this.lib1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmConsume";
            this.Text = "Kombiz and Youssef";
            this.Load += new System.EventHandler(this.FrmConsume_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lib1;
        private System.Windows.Forms.Label lib2;
        private System.Windows.Forms.Label lib3;
        private System.Windows.Forms.TextBox txtBoxDist;
        private System.Windows.Forms.TextBox txtBoxLit;
        private System.Windows.Forms.TextBox txtBoxPL;
        private System.Windows.Forms.Label lib4;
        private System.Windows.Forms.Label lib5;
        private System.Windows.Forms.Label libOut1;
        private System.Windows.Forms.Label libOut2;
        private System.Windows.Forms.Button btnCalc;
        private System.Windows.Forms.Button btnClr;
        private System.Windows.Forms.Button btnExt;
    }
}