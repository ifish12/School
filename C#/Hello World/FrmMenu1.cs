using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace First_Project
{
    public partial class FrmMenu1 : Form
    {
        public FrmMenu1()
        {
            InitializeComponent();
        }

        private void btnHello_Click(object sender, EventArgs e)
        {
            // Don't ask.
            Frmhello itsybitsyspider = new Frmhello();
            itsybitsyspider.Show();

        }

        private void btnDate_Click(object sender, EventArgs e)
        {
            FrmDate1 itsybitsyspider = new FrmDate1();
            itsybitsyspider.Show();
        }

        private void btncon_Click(object sender, EventArgs e)
        {
            FrmConsume itsybitsyspider = new FrmConsume();
            itsybitsyspider.Show();
        }

        private void btnArea_Click(object sender, EventArgs e)
        {
            FrmArea itsybitsyspider = new FrmArea();
            itsybitsyspider.Show();
        }
    }
}
