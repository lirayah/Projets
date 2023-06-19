<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Sondage extends CI_Controller{

    public function __construct()
    {
        parent::__construct();
        $this->load->library('session');
    }

    public function create(){        
        if(isset($this->session->logged['logged_in'])){
            $this->form_validation->set_rules('titre','Titre','required');
            $this->form_validation->set_rules('lieu','Lieu','required');
            $this->form_validation->set_rules('descriptif','Descriptif','required');
            $this->form_validation->set_rules('dates[]','Dates','required');

            if($this->form_validation->run() === FALSE){
                $this->load->view('layout/header');
                $this->load->view('create_sondage');
                $this->load->view('layout/footer');
            } else{
                $this->load->model('modelSondage');
                $titre=$this->input->post('titre');
                $lieu=$this->input->post('lieu');
                $descriptif=$this->input->post('descriptif');
                $dates=$this->input->post('dates');
                $cle=$this->modelSondage->random_kiki();
                $createur=$this->session->logged['login'];
                $this->modelSondage->creation($titre,$lieu,$descriptif,$createur,$dates,$cle);
                redirect('/consulter/profil');
            }
        }
        else{
            redirect('/user/login');
        }
    }


    public function fermeture(){
        $this->load->model('modelSondage');
        $this->modelSondage->fermeture($this->input->get('cle'));
        redirect('/consulter/profil');
    }

    public function ouverture(){
        $this->load->model('modelSondage');
        $this->modelSondage->ouverture($this->input->get('cle'));
        redirect('/consulter/profil');
    }


    public function suppression(){
        $this->load->model('modelSondage');
        $this->modelSondage->suppression($this->input->get('cle'));
        redirect('/consulter/profil');
    }


    public function modifier(){
        if(isset($this->session->logged['logged_in'])){
            $cle=$this->input->get('cle');
            $this->load->model('ModelSondage');
            $infos=$this->ModelSondage->getInfos($cle);
            $this->form_validation->set_rules('titre','Titre','required');
            $this->form_validation->set_rules('lieu','Lieu','required');
            $this->form_validation->set_rules('descriptif','Descriptif','required');

            if($this->form_validation->run() === FALSE){
                $this->load->view('layout/header');
                $this->load->view('modif_sondage',['infos'=>$infos]);
                $this->load->view('layout/footer');
            } else{                
                $titre=$this->input->post('titre');
                $lieu=$this->input->post('lieu');
                $descriptif=$this->input->post('descriptif');
                $cle=$this->input->get('cle');
                $this->ModelSondage->modifier($titre,$lieu,$descriptif,$cle);
                redirect('/consulter/regarder?cle='.$cle);
            }
        }
        else{
            redirect('/user/login');
        }
    }
    
    public function merci()
    {
        $this->load->view('layout/header');
        $this->load->view('merci');
        $this->load->view('layout/footer');
    }
}
?>