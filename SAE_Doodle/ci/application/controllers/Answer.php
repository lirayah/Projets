<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Answer extends CI_Controller{
    public function __construct()
    {
        parent::__construct();
        
    }
    public function index()
    {
        $this->load->model('Model_Reponses');
        if ($this->Model_Reponses->isOpen($this->input->get('cle'))) {
            $data=$this->Model_Reponses->getInfos($this->input->get('cle'));
            $this->form_validation->set_rules('nom','Nom','required');
            $this->form_validation->set_rules('prenom','Prénom','required');

            if ($this->form_validation->run()===FALSE) {
                $this->load->view('layout/header');
                $this->load->view('vue_reponses',['data'=>$data]);
                $this->load->view('layout/footer');
            } else {
                $cle=$this->input->get('cle');
                $nom=$this->input->post('nom');
                $prenom=$this->input->post('prenom');
                $dates=$this->input->post('dates[]');
                $i=0;
                foreach ($dates as $dadates) {
                    $datesfin[$i]= date('Y-m-d H:i:s',$dadates);
                    $i++;
                }
                $id=$this->Model_Reponses->setParticipants($cle,$nom,$prenom);
                $this->Model_Reponses->setDates($id,$datesfin,$cle);
                redirect('Sondage/merci');
            }
        } else {
            $mess="Ce sondage n'existe pas!";
            $this->load->view('layout/header');
            $this->load->view('welcome_message',['mess'=>$mess]);
            $this->load->view('layout/footer');
        }
    }
}


?>