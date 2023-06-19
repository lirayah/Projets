<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Consulter extends CI_Controller {
    

    public function profil()
    {
        $this->load->library('session');
        $this->load->model('Model_consulter');
        $login=$this->session->logged['login'];
        $infos=$this->Model_consulter->aff_profil($login);

        $this->load->view('layout/header');
        $this->load->view('View_profil',['infos'=>$infos]);
        $this->load->view('layout/footer');
    }


    public function regarder()
    {
        $this->load->library('session');
        $this->load->model('Model_consulter');
        $cle=$this->input->get('cle');
        $testlogin=$this->Model_consulter->céletien($cle);
        if ($this->session->logged['login']==$testlogin[0]['createur']){
            $sondage=$this->Model_consulter->recup_sond($cle);
            $propositions=$this->Model_consulter->recup_prop($cle);
            $participants=$this->Model_consulter->recup_par($cle);
        
            $this->load->view('layout/header');
            $array[0]=$sondage;
            $array[1]=$propositions;
            $array[2]=$participants;
            $this->load->view('View_consulter',['array'=>$array]);
            $this->load->view('layout/footer');
        }
        else {
            redirect('/consulter/profil');
        }
    }
}