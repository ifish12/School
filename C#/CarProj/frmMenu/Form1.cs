using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace frmMenu
{
    public partial class frmMenu : Form
    {
        public frmMenu()
        {
            InitializeComponent();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            frmFord itsybitsyspider = new frmFord();
            itsybitsyspider.Show();

            this.Hide();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            frmAcura itsybitsyspider = new frmAcura();
            itsybitsyspider.Show();

            this.Hide();      
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmInfinit itsybitsyspider = new frmInfinit();
            itsybitsyspider.Show();

            this.Hide();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            MessageBox.Show("You've gotta be kidding, right?");
        }

        private void pictureBox5_Click(object sender, EventArgs e)
        {
            frmNissain itsybitsyspider = new frmNissain();
            itsybitsyspider.Show();

            this.Hide();
        }

        private void pictureBox6_Click(object sender, EventArgs e)
        {
            frmHonda itsybitsyspider = new frmHonda();
            itsybitsyspider.Show();

            this.Hide();
        }

        private void btnSuperMegaCloseButton_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);

        }

        private void frmMenu_Load(object sender, EventArgs e)
        {

        }

       
       

      

     

        
    }
}
