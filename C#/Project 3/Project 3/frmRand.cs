using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project_3
{
    public partial class frmRand : Form
    {
        int spins = 0;
        int numb1, numb2, numb3;
        int wins = 0;
        double percent = 0;
        public frmRand()
        {
            InitializeComponent();
        }

        private void Exit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSpin_Click(object sender, EventArgs e)
        {
            pictureBox1.Visible = false;
            spins++;
            lblOutSpins.Text = spins.ToString("N0");

            Random rand = new Random();

            numb1 = rand.Next(10);
            lbl1.Text = numb1.ToString("N0");

            numb2 = rand.Next(10);
            lbl2.Text = numb2.ToString("N0");

            numb3 = rand.Next(10);
            lbl3.Text = numb3.ToString("N0");

            if (numb1 == 7 || numb2 == 7 || numb3 == 7)
            {
                wins++;
                lblOutWin.Text = wins.ToString("N0");
                pictureBox1.Visible = true;

            }
            percent = (double)wins / spins;
           
               lblOutPercent.Text = percent.ToString("P");
            



        }
    }

}
