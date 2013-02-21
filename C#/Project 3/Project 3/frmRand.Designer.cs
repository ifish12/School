namespace Project_3
{
    partial class frmRand
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmRand));
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lbl3 = new System.Windows.Forms.Label();
            this.btnSpin = new System.Windows.Forms.Button();
            this.Exit = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.lblWins = new System.Windows.Forms.Label();
            this.lblSpins = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lblOutWin = new System.Windows.Forms.Label();
            this.lblOutSpins = new System.Windows.Forms.Label();
            this.lblOutPercent = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // lbl1
            // 
            this.lbl1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lbl1.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl1.Location = new System.Drawing.Point(210, 9);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(63, 87);
            this.lbl1.TabIndex = 0;
            // 
            // lbl2
            // 
            this.lbl2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lbl2.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl2.Location = new System.Drawing.Point(292, 9);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(63, 87);
            this.lbl2.TabIndex = 1;
            // 
            // lbl3
            // 
            this.lbl3.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lbl3.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl3.Location = new System.Drawing.Point(371, 9);
            this.lbl3.Name = "lbl3";
            this.lbl3.Size = new System.Drawing.Size(63, 87);
            this.lbl3.TabIndex = 2;
            // 
            // btnSpin
            // 
            this.btnSpin.Location = new System.Drawing.Point(13, 13);
            this.btnSpin.Name = "btnSpin";
            this.btnSpin.Size = new System.Drawing.Size(125, 53);
            this.btnSpin.TabIndex = 3;
            this.btnSpin.Text = "Spin";
            this.btnSpin.UseVisualStyleBackColor = true;
            this.btnSpin.Click += new System.EventHandler(this.btnSpin_Click);
            // 
            // Exit
            // 
            this.Exit.Location = new System.Drawing.Point(13, 86);
            this.Exit.Name = "Exit";
            this.Exit.Size = new System.Drawing.Size(125, 53);
            this.Exit.TabIndex = 4;
            this.Exit.Text = "Exit";
            this.Exit.UseVisualStyleBackColor = true;
            this.Exit.Click += new System.EventHandler(this.Exit_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(239, 149);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(185, 130);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 5;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Visible = false;
            // 
            // lblWins
            // 
            this.lblWins.AutoSize = true;
            this.lblWins.Location = new System.Drawing.Point(13, 179);
            this.lblWins.Name = "lblWins";
            this.lblWins.Size = new System.Drawing.Size(31, 13);
            this.lblWins.TabIndex = 6;
            this.lblWins.Text = "Wins";
            // 
            // lblSpins
            // 
            this.lblSpins.AutoSize = true;
            this.lblSpins.Location = new System.Drawing.Point(10, 216);
            this.lblSpins.Name = "lblSpins";
            this.lblSpins.Size = new System.Drawing.Size(33, 13);
            this.lblSpins.TabIndex = 7;
            this.lblSpins.Text = "Spins";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(13, 253);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(31, 13);
            this.label3.TabIndex = 8;
            this.label3.Text = "%%%";
            // 
            // lblOutWin
            // 
            this.lblOutWin.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblOutWin.Location = new System.Drawing.Point(88, 179);
            this.lblOutWin.Name = "lblOutWin";
            this.lblOutWin.Size = new System.Drawing.Size(74, 13);
            this.lblOutWin.TabIndex = 9;
            // 
            // lblOutSpins
            // 
            this.lblOutSpins.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblOutSpins.Location = new System.Drawing.Point(88, 215);
            this.lblOutSpins.Name = "lblOutSpins";
            this.lblOutSpins.Size = new System.Drawing.Size(74, 13);
            this.lblOutSpins.TabIndex = 10;
            // 
            // lblOutPercent
            // 
            this.lblOutPercent.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblOutPercent.Location = new System.Drawing.Point(88, 252);
            this.lblOutPercent.Name = "lblOutPercent";
            this.lblOutPercent.Size = new System.Drawing.Size(74, 13);
            this.lblOutPercent.TabIndex = 11;
            // 
            // frmRand
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(446, 371);
            this.Controls.Add(this.lblOutPercent);
            this.Controls.Add(this.lblOutSpins);
            this.Controls.Add(this.lblOutWin);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblSpins);
            this.Controls.Add(this.lblWins);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.Exit);
            this.Controls.Add(this.btnSpin);
            this.Controls.Add(this.lbl3);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Name = "frmRand";
            this.Text = "frmRand";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.Label lbl3;
        private System.Windows.Forms.Button btnSpin;
        private System.Windows.Forms.Button Exit;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label lblWins;
        private System.Windows.Forms.Label lblSpins;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lblOutWin;
        private System.Windows.Forms.Label lblOutSpins;
        private System.Windows.Forms.Label lblOutPercent;
    }
}