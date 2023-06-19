<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User extends CI_Controller {


	public function create()
	{
		$this->load->model('model_user');
		$this->load->library('form_validation');
		$this->form_validation->set_rules('nom', 'Nom', 'required');
		$this->form_validation->set_rules('prenom', 'Prénom', 'required');
		$this->form_validation->set_rules('email', 'Adresse mail', 'valid_email|required');
		$this->form_validation->set_rules('password', 'current password', 'min_length[5]|required');
		$this->form_validation->set_rules('cpassword', 'confirm password', 'required|matches[password]');
		$this->form_validation->set_rules('login', 'Login', 'min_length[3]|required');


		if ($this->form_validation->run() === FALSE){
			$this->load->view('layout/header');
			$this->load->view('create_user_form');
			$this->load->view('layout/footer');
		}else{
			$login=$this->input->post('login');
			if ($this->model_user->verification($login)) {
				$name=$this->input->post('nom');
				$prenom=$this->input->post('prenom');
				$email=$this->input->post('email');
				$passhash = password_hash($this->input->post('password'),PASSWORD_DEFAULT);
				$this->model_user->creerCompte($name,$prenom,$email,$passhash,$login);
				redirect('/user/login');
			} else {
				$erreur="Login already taken";
				$this->load->view('layout/header');
				$this->load->view('create_user_form',['erreur'=>$erreur]);
				$this->load->view('layout/footer');
			}
		}
	}

	public function login()
	{
		$this->load->model('model_user');
		$this->load->library('form_validation');
		$this->form_validation->set_rules('login','current login','min_length[3]|required');
		$this->form_validation->set_rules('password', 'current password', 'min_length[5]|required');
		if($this->form_validation->run() === FALSE){
			$this->load->view('layout/header');
			$this->load->view('login');
			$this->load->view('layout/footer');
		} else {
			$login=$this->input->post('login');
			$password=$this->input->post('password');
			$hash = $this->model_user->authentification($login);
			if($hash){
				if(password_verify($password,$hash)){
					$this->load->library('session');
					$this->session->set_userdata('logged',$this->model_user->info($login));
					redirect('/consulter/profil');
				} else {
					$erreur="Login credentials invalid";
					$this->load->view('layout/header');
					$this->load->view('login',['erreur'=>$erreur]);
					$this->load->view('layout/footer');
				}
			} else {
				$erreur="Login credentials invalid";
				$this->load->view('layout/header');
				$this->load->view('login',['erreur'=>$erreur]);
				$this->load->view('layout/footer');
			}
		}
	}

	public function modifier()
    {
        $this->load->library('session');
        $this->load->model('Model_user');
		$this->load->library('form_validation');
		$oldlogin=$this->session->logged['login'];
		$infos=$this->Model_user->getInfos($oldlogin);
		$this->form_validation->set_rules('nom', 'Nom', 'required');
		$this->form_validation->set_rules('prenom', 'Prénom', 'required');
		$this->form_validation->set_rules('email', 'Adresse mail', 'valid_email|required');
		$this->form_validation->set_rules('password', 'current password', 'min_length[5]|required');
		$this->form_validation->set_rules('cpassword', 'confirm password', 'required|matches[password]');
		$this->form_validation->set_rules('login', 'Login', 'min_length[3]|required');


		if ($this->form_validation->run() === FALSE){
			$this->load->view('layout/header');
			$this->load->view('modif_user',['infos'=>$infos]);
			$this->load->view('layout/footer');
		}else{
			$newlogin=$this->input->post('login');
			if ($this->Model_user->verification($newlogin) or $oldlogin=$newlogin) {
				$name=$this->input->post('nom');
				$prenom=$this->input->post('prenom');
				$email=$this->input->post('email');
				$passhash = password_hash($this->input->post('password'),PASSWORD_DEFAULT);
				$this->Model_user->modifierCompte($name,$prenom,$email,$passhash,$newlogin,$oldlogin);
				$this->session->set_userdata('logged',$this->Model_user->info($newlogin));
				redirect('/consulter/profil');
			} else {
				$erreur="Login already taken";
				$this->load->view('layout/header');
				$this->load->view('modif_user',['erreur'=>$erreur]);
				$this->load->view('layout/footer');
			}
		}
    }
}
