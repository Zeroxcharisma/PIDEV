<?php

namespace App\Form;

use App\Entity\Reclamation;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ReclamationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('email')
            ->add('sujet')
            ->add('description')
            ->add('etat',  ChoiceType::class, [
               
                'choices' => [
                   



                    ' traitée.' => ' traitée.',
            'en cours de traitement ' => 'en cours de traitement ',
            'annulé ' => 'annulé ',
                ] ])
            ->add('idCoach')
            ->add('idUser')
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Reclamation::class,
        ]);
    }
}
