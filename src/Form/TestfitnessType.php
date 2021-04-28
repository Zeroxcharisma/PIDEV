<?php

namespace App\Form;

use App\Entity\Cours;
use App\Entity\Testfitness;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class TestfitnessType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('cours', EntityType::class, [
                'class' => Cours::class,
                'choice_label' => 'nom'
            ])
            ->add('duree')
            ->add('dateTest')
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Testfitness::class,
        ]);
    }
}
