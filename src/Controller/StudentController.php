<?php

namespace App\Controller;

use App\Entity\Student;
use App\Form\StudentType;
use App\Repository\StudentRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class StudentController extends AbstractController
{
    /**
     * @Route("/student", name="student")
     */
    public function index()
    {
        return $this->render('student/index.html.twig', [
            'controller_name' => 'StudentController',
        ]);
    }

    /**
     * @Route("/students_Affiche", name="students_Affiche")
     * @param StudentRepository $repo
     * @return Response
     */
    function AfficheStudens(StudentRepository $repo) {
        // $repo=$this->getDoctrine()->getRepository(Classroom::class);
        $students=$repo->findAll();
        return $this->render("student/AfficheS.html.twig", ['students'=>$students]);
    }
    /**
     * @Route("/student_delete/{id}", name="Delete")
     * @param int $id
     * @return RedirectResponse
     */
    function Delete(int $id) {
        $repo=$this->getDoctrine()->getRepository(Student::class);
        $entityManage=$this->getDoctrine()->getManager();
        $student=$repo->find($id);
        $entityManage->remove($student);
        $entityManage->flush();
        return $this->redirectToRoute("students_Affiche");
    }
    /**
     * @Route("/student_add", name="Ajout")
     */
    function AjoutS(Request $request) {
        $student = new Student();
        $form=$this->createForm(studentType::class, $student);
        $form->add("Ajouter", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em=$this->getDoctrine()->getManager();
            $em->persist($student);
            $em->flush();
            return $this->redirectToRoute("students_Affiche");
        }
        $title = "Add new student ";
        return $this->render("student/addStudent.html.twig", [
            'f' =>$form->createView(),
            'page_title' => $title
        ]);

    }

    /**
     * @param Request $request
     * @return RedirectResponse|Response
     * @Route("/student_update/{id}")
     */
    function UpdateC(Request $request, int $id) {
        $repo=$this->getDoctrine()->getRepository(Student::class);
        $entityManage=$this->getDoctrine()->getManager();
        $oldStudent=$repo->find($id);
        $form=$this->createForm(StudentType::class, $oldStudent);
        $form->add("Update", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em=$this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute("students_Affiche");
        }
        $title = "Update student";
        return $this->render("student/addStudent.html.twig", [
            'f' =>$form->createView(),
            'page_title' => $title
        ]);

    }
}
