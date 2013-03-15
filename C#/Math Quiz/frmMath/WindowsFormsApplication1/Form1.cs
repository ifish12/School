using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        int count = 0;
        int right = 0;
        int wrong = 0;
       double rep1 = 0;
       double rep2 = 0;
       double rep3 = 0;
       double rep4 = 0;
       double rep5 = 0;

       double ans1 = 0;
       double ans22 = 0;
       double ans3 = 0;
       double ans4 = 0;
       double ans5 = 0;



        public Form1()
        {
            InitializeComponent();
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void btnEasy_Click(object sender, EventArgs e)
        {
            
            count = 15;
            timer1.Start();

            Random rand = new Random();
            lblRand1.Text = Convert.ToString(rand.Next(0, 10));
            lblRand2.Text = Convert.ToString(rand.Next(0, 10));
            lblRand3.Text = Convert.ToString(rand.Next(0, 10));
            lblRand4.Text = Convert.ToString(rand.Next(0, 10));
            lblRand5.Text = Convert.ToString(rand.Next(0, 10));
            lblRand6.Text = Convert.ToString(rand.Next(0, 10));
            lblRand7.Text = Convert.ToString(rand.Next(0, 10));
            lblRand8.Text = Convert.ToString(rand.Next(0, 10));
            lblRand9.Text = Convert.ToString(rand.Next(0, 10));
            lblRand10.Text = Convert.ToString(rand.Next(0, 10));
        }

        private void btnMed_Click(object sender, EventArgs e)
        { 
            count = 25;
            timer1.Start();
           
            Random rand = new Random();
            lblRand1.Text = Convert.ToString(rand.Next(0, 20));
            lblRand2.Text = Convert.ToString(rand.Next(0, 20));
            lblRand3.Text = Convert.ToString(rand.Next(0, 20));
            lblRand4.Text = Convert.ToString(rand.Next(0, 20));
            lblRand5.Text = Convert.ToString(rand.Next(0, 20));
            lblRand6.Text = Convert.ToString(rand.Next(0, 20));
            lblRand7.Text = Convert.ToString(rand.Next(0, 20));
            lblRand8.Text = Convert.ToString(rand.Next(0, 20));
            lblRand9.Text = Convert.ToString(rand.Next(0, 20));
            lblRand10.Text = Convert.ToString(rand.Next(0, 20));
        }

        private void btnHard_Click(object sender, EventArgs e)
        {
            count = 30;
            timer1.Start();
            
            Random rand = new Random();
            lblRand1.Text = Convert.ToString(rand.Next(0, 30));
            lblRand2.Text = Convert.ToString(rand.Next(0, 30));
            lblRand3.Text = Convert.ToString(rand.Next(0, 30));
            lblRand4.Text = Convert.ToString(rand.Next(0, 30));
            lblRand5.Text = Convert.ToString(rand.Next(0, 30));
            lblRand6.Text = Convert.ToString(rand.Next(0, 30));
            lblRand7.Text = Convert.ToString(rand.Next(0, 30));
            lblRand8.Text = Convert.ToString(rand.Next(0, 30));
            lblRand9.Text = Convert.ToString(rand.Next(0, 30));
            lblRand10.Text = Convert.ToString(rand.Next(0, 30));
        }

        private void btnFin_Click(object sender, EventArgs e)
        {
            ans1  = Convert.ToDouble(lblRand1.Text) * Convert.ToDouble(lblRand10.Text);
            ans22 = Convert.ToDouble(lblRand2.Text) * Convert.ToDouble(lblRand9.Text);
            ans3  = Convert.ToDouble(lblRand3.Text) * Convert.ToDouble(lblRand8.Text);
            ans4  = Convert.ToDouble(lblRand4.Text) * Convert.ToDouble(lblRand7.Text);
            ans5  = Convert.ToDouble(lblRand5.Text) * Convert.ToDouble(lblRand6.Text);

            rep1 = Convert.ToDouble(ansT1.Text);
            rep2 = Convert.ToDouble(ansT2.Text);
            rep3 = Convert.ToDouble(ansT3.Text);
            rep4 = Convert.ToDouble(ansT4.Text);
            rep5 = Convert.ToDouble(ansT5.Text);

            if (ans1 == rep1)
            {
                txt1.ForeColor = Color.Green;
                right = right + 1;

            }
            else
            {
                txt1.ForeColor = Color.Red;
                wrong = wrong + 1;
            }

            if (ans22 == rep2)
            {
                txt2.ForeColor = Color.Green;
                right = right + 1;
            }
            else
            {
                txt2.ForeColor = Color.Red;
                wrong = wrong + 1;
            }

            if (ans3 == rep3)
            {
                txt3.ForeColor = Color.Green;
                right = right + 1;
            }
            else
            {
                txt3.ForeColor = Color.Red;
                wrong = wrong + 1;
            }
            if (ans4 == rep4)
            {
                txt4.ForeColor = Color.Green;
                right = right + 1;
            }
            else
            {
                txt4.ForeColor = Color.Red;
                wrong = wrong + 1;
            }

            if (ans5 == rep5)
            {
                txt5.ForeColor = Color.Green;
                right = right + 1;
            }
            else
            {
                txt5.ForeColor = Color.Red;
                wrong = wrong + 1;
            }

            txt1.Text = Convert.ToString(ans1);
            txt2.Text = Convert.ToString(ans22);
            txt3.Text = Convert.ToString(ans3);
            txt4.Text = Convert.ToString(ans4);
            txt5.Text = Convert.ToString(ans5);

            timer1.Stop();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lblTimer.Text = count.ToString(); 
            
            if (count <= 0)
            {
                timer1.Stop();
                btnFin.PerformClick();
            }

            count = count - 1;


           


        }

        private void btnClr_Click(object sender, EventArgs e)
        {

        }
    }
}
