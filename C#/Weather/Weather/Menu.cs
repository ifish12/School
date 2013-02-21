using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Weather
{
    public partial class frmMenu : Form
    {
        public frmMenu()
        {
            InitializeComponent();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            frmRadioCheck spider = new frmRadioCheck();
            spider.Show();
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            frmTemperature dere = new frmTemperature();
            dere.Show();
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            frmWeather ray = new frmWeather();
            ray.Show();
        }

    }
}
